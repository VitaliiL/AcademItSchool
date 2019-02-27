package ru.academits.Matrix.LV.matrix;

import ru.academits.Vector.LV.vector.Vector;

class Verification {
    static void verifyIndex() {
        throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
    }

    static void verifySize() {
        throw new IllegalArgumentException("Matrix column numbers must equals the vector size.");
    }

    static void verifyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("The rows or columns count are unequal.");
        }
    }

    static void verifyDoubleArrayLength(double[][] array, int maxLength) {
        if (array.length == 0 || maxLength == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }
    }

    static void verifyVectorArrayLength(Vector[] vectorArray) {
        if (vectorArray.length == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }
    }

    static void verifyRowAndColumns(int rowAmount, int columnAmount) {
        if (rowAmount <= 0 || columnAmount <= 0) {
            throw new IllegalArgumentException("The values aren't correct.");
        }
    }

    static void verifyMatrixForSubAndSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() && matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Matrices must be equal order. Check count rows and columns of matrices.");
        }
    }

    static void verifyMatrixForMult(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Amount columns of the first matrix must be equal amount rows of the second matrix.");
        }
    }
}

