package ru.academits.Matrix.LV.main;

import ru.academits.Matrix.LV.matrix.Matrix;
import ru.academits.Vector.LV.vector.Vector;

public class Main {
    public static void main(String[] args) {
        try {//to check constructors:
            Matrix matrix = new Matrix(2, 2);
            System.out.println(matrix);

            Matrix matrix2 = new Matrix(3, 4);
            Matrix matrix3 = new Matrix(matrix2);
            System.out.println(matrix3);

            double[][] array = new double[][]{{0, 1, 2}, {2, 3, 4, 5, 6}};
            Matrix matrix4 = new Matrix(array);
            System.out.println(matrix4);

            Vector vector1 = new Vector(new double[]{1, 6, 10});
            Vector vector2 = new Vector(new double[]{1, 6, 10, 15, 17});
            Vector[] vector = {vector1, vector2};
            Matrix matrix5 = new Matrix(vector);
            System.out.println(matrix5);
            System.out.println();

            //to check methods:
            System.out.println("Matrix rows amount: " + matrix5.getRowsCount());
            System.out.println("Matrix columns amount: " + matrix5.getColumnsCount());

            Vector vector3 = new Vector(new double[]{1, 2, 3, 4, 10});
            Matrix matrix6 = new Matrix(vector);
            matrix6.setRowByIndex(1, vector3);
            System.out.println(matrix6);
            System.out.println("Get row by index: " + matrix6.getRowByIndex(1));
            System.out.println("Get columns by index: " + matrix6.getColumnByIndex(3));

            Matrix matrix7 = matrix6.transpose();
            System.out.println("Transpose:" + matrix7);
            System.out.println("Multiplication by scalar: " + matrix7.multiplyByScalar(2));

            double[][] array1 = new double[][]{{1, 2, 3}, {4, 5, 6, 7, 8}};
            Matrix matrix8 = new Matrix(array1);
            double[][] array2 = new double[][]{{2, 3, 4}, {5, 6, 7, 8, 9}};
            Matrix matrix9 = new Matrix(array2);

            Matrix sumResult = matrix9.sumMatrix(matrix8);
            System.out.println("Sum result: " + sumResult);
            Matrix subResult = matrix9.subMatrix(matrix8);
            System.out.println("Sub result: " + subResult);

            double[][] array3 = new double[][]{{2, 3, 4}, {5, 6, 7, 8, 9}};
            Matrix matrix10 = new Matrix(array3);
            Vector vector4 = new Vector(new double[]{1, 1, 1, 1, 1});
            System.out.println("Multiplication by vector: " + matrix10.multiplyByVector(vector4));
            System.out.println();

            //to check static methods:
            System.out.println("Sum result from static method: " + Matrix.sum(matrix8, matrix9));
            System.out.println("Sub result from static method: " + Matrix.sub(matrix8, matrix9));

            Matrix matrix11 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
            Matrix matrix12 = new Matrix(new double[][]{{1, 2}, {4, 5}, {7, 8}});
            System.out.println("Matrix's multiplication: " + Matrix.mult(matrix11, matrix12));

            Matrix matrix13 = new Matrix(new double[][]{{5}});
            System.out.println("Determinant: " + matrix13.getDeterminant());

        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error during the program executing by cause: " + e.getMessage());
        }
    }
}
