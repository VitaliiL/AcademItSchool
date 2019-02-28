package ru.academits.Matrix.LV.matrix;

import ru.academits.Vector.LV.vector.Vector;

import static ru.academits.Matrix.LV.matrix.Verification.*;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        verifyRowAndColumns(rowsCount, columnsCount);

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.rows);
    }

    public Matrix(double[][] array) {
        int maxLength = 0;

        for (double[] element : array) {
            if (element.length > maxLength) {
                maxLength = element.length;
            }
        }

        verifyDoubleArrayLength(array, maxLength);

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        verifyVectorArrayLength(vectorArray);

        int numColumns = 0;

        for (Vector element : vectorArray) {
            if (numColumns < element.getSize()) {
                numColumns = element.getSize();
            }
        }

        rows = new Vector[vectorArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            rows[i] = new Vector(numColumns, vectorArray[i]); //Constructor was added in the vector class as vector(int n, vector vector)
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        for (Vector component : rows) {
            s.append(component.toString()).append(", ");
        }

        s.setLength(s.length() - 2);
        s.append("}");

        return s.toString();
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index >= getColumnsCount() || index < 0) {
            verifyIndex();
        } else if (getColumnsCount() != vector.getSize()) {
            verifySize();
        }

        rows[index] = new Vector(vector);
    }

    public Vector getRowByIndex(int index) {
        if (index >= getColumnsCount() || index < 0) {
            verifyIndex();
        }

        return new Vector(rows[index]);
    }

    public Vector getColumnByIndex(int index) {
        if (index >= getColumnsCount() || index < 0) {
            verifyIndex();
        }

        Vector vector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            vector.setComponentByIndex(i, rows[i].getComponentByIndex(index));
        }

        return vector;
    }

    public Matrix transpose() {
        Vector[] vector = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); i++) {
            vector[i] = getColumnByIndex(i);
        }

        rows = vector;

        return this;
    }

    public Matrix multiplyByScalar(int scalar) {
        for (Vector element : rows) {
            element.multiplyByScalar(scalar);
        }

        return this;
    }

    public Matrix sumMatrix(Matrix matrix) {
        verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsCount(); ++i) {
            rows[i].addToVector(matrix.rows[i]);
        }

        return this;
    }

    public Matrix subMatrix(Matrix matrix) {
        verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsCount(); ++i) {
            rows[i].subtractFromVector(matrix.rows[i]);
        }

        return this;
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            verifySize();
        }

        Vector vectorResult = new Vector(this.getRowsCount());

        for (int i = 0; i < this.getRowsCount(); i++) {
            vectorResult.setComponentByIndex(i, Vector.getScalarMultiplication(this.rows[i], vector));
        }

        return vectorResult;
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        verifyMatrixForSubAndSum(matrix1, matrix2);
        Matrix matrix = new Matrix(matrix1);

        return matrix.sumMatrix(matrix2);
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2) {
        verifyMatrixForSubAndSum(matrix1, matrix2);
        Matrix matrix = new Matrix(matrix1);

        return matrix.subMatrix(matrix2);
    }

    public static Matrix mult(Matrix matrix1, Matrix matrix2) {
        verifyMatrixForMult(matrix1, matrix2);

        double[][] elements = new double[matrix1.getRowsCount()][matrix2.getColumnsCount()];

        for (int i = 0; i < matrix1.getRowsCount(); i++) {
            for (int j = 0; j < matrix2.getColumnsCount(); j++) {
                elements[i][j] = Vector.getScalarMultiplication(matrix1.rows[i], matrix2.getColumnByIndex(j));
            }
        }

        return new Matrix(elements);
    }

    //determinant:
    public double getDeterminant() {
        return calculateDeterminant(this);
    }

    private double calculateDeterminant(Matrix matrix) {
        verifyQuadraticMatrix(matrix);

        double result = 0;

        if (matrix.rows.length == 2) {
            result = matrix.rows[0].getComponentByIndex(0) * matrix.rows[1].getComponentByIndex(1) - matrix.rows[1].getComponentByIndex(0) * matrix.rows[0].getComponentByIndex(1);
        } else {
            int element;

            for (int i = 0; i < matrix.rows.length; i++) {
                if (i % 2 == 1) {
                    element = -1;
                } else {
                    element = 1;
                }

                result += element * matrix.rows[0].getComponentByIndex(i) * calculateDeterminant(getMinor(matrix, i));
            }
        }

        return result;
    }

    private Matrix getMinor(Matrix matrix, int column) {
        int minorLength = matrix.rows.length - 1;

        double[][] minor = new double[minorLength][minorLength];
        int skipRow = 0;

        for (int i = 0; i <= minorLength; i++) {
            int skipColumn = 0;

            for (int j = 0; j <= minorLength; j++) {
                if (i == 0) {
                    skipRow = 1;
                } else {
                    if (j == column) {
                        skipColumn = 1;
                    } else {
                        minor[i - skipRow][j - skipColumn] = matrix.rows[i].getComponentByIndex(j);
                    }
                }
            }
        }

        return new Matrix(minor);
    }
}

