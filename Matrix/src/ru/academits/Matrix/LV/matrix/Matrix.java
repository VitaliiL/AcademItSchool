package ru.academits.Matrix.LV.matrix;

import ru.academits.Vector.LV.Vector.Vector;

public class Matrix {
    private Vector[] row;

    public Matrix(int rowAmount, int columnAmount) {
        if (rowAmount <= 0 || columnAmount <= 0) {
            throw new IllegalArgumentException("The values aren't correct.");
        }

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

        if (array.length == 0 || maxLength == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }

        row = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            row[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        if (vectorArray.length == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }

        int numColumns = 0;

        for (Vector element : vectorArray) {
            if (numColumns < element.getSize()) {
                numColumns = element.getSize();
            }
        }

        row = new Vector[vectorArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            row[i] = new Vector(numColumns, vectorArray[i]); //Constructor was added in the Vector class as Vector(int n, Vector vector)
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
        s.append("}");

        return s.toString();
    }

    public int getRowsAmount() {
        return row.length;
    }

    public int getColumnsAmount() {
        return row[0].getSize();
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index >= getRowsAmount() || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
        } else if (vector.getSize() != getColumnsAmount()) {
            throw new IndexOutOfBoundsException("Vector size isn't correct.");
        }

        row[index] = new Vector(vector);
    }

    public Vector getRowByIndex(int index) {
        if (index >= getRowsAmount() || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
        }

        return new Vector(row[index]);
    }

    public Vector getColumnByIndex(int index) {
        if (index >= getColumnsAmount() || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
        }

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

    private static void verifyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getColumnsAmount() || matrix1.getRowsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("The matrices are different.");
        }
    }

    public Matrix sumRowMatrix(Matrix matrix) {
        verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsAmount(); ++i) {
            row[i].addToVector(matrix.row[i]);
        }

        return this;
    }

    public Matrix subRowMatrix(Matrix matrix) {
        verifyMatrix(this, matrix);

        for (int i = 0; i < matrix.getRowsAmount(); ++i) {
            row[i].subtractFromVector(matrix.row[i]);
        }

        return this;
    }

    //need add methods (2)


    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.sumRowMatrix(matrix2);
    }

    public static Matrix sub(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.subRowMatrix(matrix2);
    }

    //need add method (1)

}
