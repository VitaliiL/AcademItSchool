package ru.academits.Matrix.LV.matrix;

import ru.academits.Vector.LV.Vector.Vector;

class Exception {
    static void checkIndex(Matrix matrix, int index) {
        if (index >= matrix.getColumnsAmount() || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
        }
    }

    static void checkSize(Matrix matrix, Vector vector) {
        if (matrix.getColumnsAmount() != vector.getSize()) {
            throw new IllegalArgumentException("Matrix column numbers must equals the vector size.");
        }
    }

    static void verifyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getColumnsAmount() || matrix1.getRowsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("The matrices are different.");
        }
    }

    static void checkDoubleArrayLength(double[][] array, int maxLength) {
        if (array.length == 0 || maxLength == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }
    }

    static void checkVectorArrayLength(Vector[] vectorArray) {
        if (vectorArray.length == 0) {
            throw new IllegalArgumentException("Length is 0.");
        }
    }

    static void checkRowAndColumns(int rowAmount, int columnAmount) {
        if (rowAmount <= 0 || columnAmount <= 0) {
            throw new IllegalArgumentException("The values aren't correct.");
        }
    }

    static void checkMatrixForMult(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("Amount columns of the first matrix must be equal amount rows of the second matrix.");
        }
    }
}

