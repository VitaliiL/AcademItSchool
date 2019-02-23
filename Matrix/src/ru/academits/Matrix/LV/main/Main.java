package ru.academits.Matrix.LV.main;

import ru.academits.Matrix.LV.matrix.Matrix;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(2, 2);
        System.out.println(matrix.toString());

        Matrix matrix2 = new Matrix(3, 4);
        Matrix matrix3 = new Matrix(matrix2);
        System.out.println(matrix3.toString());



    }
}
