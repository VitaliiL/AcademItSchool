package ru.academits.Matrix.LV.main;

import ru.academits.Matrix.LV.matrix.Matrix;
import ru.academits.Vector.LV.Vector.Vector;

public class Main {
    public static void main(String[] args) {

        //to check constructors:
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
        System.out.println("Matrix rows amount: " + matrix5.getRowsAmount());
        System.out.println("Matrix columns amount: " + matrix5.getColumnsAmount());

        Vector vector3 = new Vector(new double[]{1, 2, 3, 4});
        Matrix matrix6 = new Matrix(vector);
        matrix6.setRowByIndex(1, vector3);
        System.out.println(matrix6);
        System.out.println(matrix6.getRowByIndex(1));
        System.out.println(matrix6.getColumnByIndex(3));

    }
}
