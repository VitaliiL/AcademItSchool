package ru.academits.Matrix.LV.matrix;

import ru.academits.Vector.LV.vector.Vector;

public class Matrix {
    private Vector[] row;

    public Matrix(int rowAmount, int columnAmount) {
        Exception.checkRowAndColumns(rowAmount, columnAmount);

        row = new Vector[rowAmount];

        for (int i = 0; i < rowAmount; i++) {
            row[i] = new Vector(columnAmount);
        }
    }

    public Matrix(Matrix matrix) {
        row = matrix.row;
    }

    public Matrix(double[][] array) {
        int maxLength = 0;

        for (double[] element : array) {
            if (element.length > maxLength) {
                maxLength = element.length;
            }
        }

        Exception.checkDoubleArrayLength(array, maxLength);

        row = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            row[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        Exception.checkVectorArrayLength(vectorArray);

        int numColumns = 0;

        for (Vector element : vectorArray) {
            if (numColumns < element.getSize()) {
                numColumns = element.getSize();
            }
        }

        row = new Vector[vectorArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            row[i] = new Vector(numColumns, vectorArray[i]); //Constructor was added in the vector class as vector(int n, vector vector)
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        for (Vector component : row) {
            s.append(component.toString()).append(",");
        }

        s.setLength(s.length() - 2);
        s.append("}}");

        return s.toString();
    }

    public int getRowsAmount() {
        return row.length;
    }

    public int getColumnsAmount() {
        return row[0].getSize();
    }

    public void setRowByIndex(int index, Vector vector) {
        Exception.checkIndex(this, index);

        row[index] = new Vector(vector);
    }

    public Vector getRowByIndex(int index) {
        Exception.checkIndex(this, index);

        return new Vector(row[index]);
    }

    public Vector getColumnByIndex(int index) {
        Exception.checkIndex(this, index);

        Vector vector = new Vector(row.length);

        for (int i = 0; i < row.length; i++) {
            vector.setComponentByIndex(i, row[i].getComponentByIndex(index));
        }

        return vector;
    }

    public Matrix transpose() {
        Vector[] vector = new Vector[getColumnsAmount()];

        for (int i = 0; i < getColumnsAmount(); i++) {
            vector[i] = getColumnByIndex(i);
        }

        row = vector;

        return this;
    }

    public Matrix multiplyByScalar(int scalar) {
        for (Vector element : row) {
            element.multiplyByScalar(scalar);
        }

        return this;
    }

    public Matrix sumMatrix(Matrix matrix) {
        Exception.verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsAmount(); ++i) {
            row[i].addToVector(matrix.row[i]);
        }

        return this;
    }

    public Matrix subMatrix(Matrix matrix) {
        Exception.verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsAmount(); ++i) {
            row[i].subtractFromVector(matrix.row[i]);
        }

        return this;
    }

    public Vector multiplyByVector(Vector vector) {
        Exception.checkSize(this, vector);

        Vector vectorResult = new Vector(this.getRowsAmount());

        for (int i = 0; i < this.getRowsAmount(); i++) {
            vectorResult.setComponentByIndex(i, Vector.getScalarMultiplication(this.row[i], vector));
        }

        return vectorResult;
    }

    //need add method determinate

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.sumMatrix(matrix2);
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.subMatrix(matrix2);
    }

    public static Matrix mult(Matrix matrix1, Matrix matrix2) {
        Exception.checkMatrixForMult(matrix1, matrix2);

        double[][] elements = new double[matrix1.getRowsAmount()][matrix2.getColumnsAmount()];

        for (int i = 0; i < matrix1.getRowsAmount(); i++) {
            for (int j = 0; j < matrix2.getColumnsAmount(); j++) {
                elements[i][j] = Vector.getScalarMultiplication(matrix1.getRowByIndex(i), matrix2.getColumnByIndex(j));
            }
        }

        return new Matrix(elements);
    }
}

