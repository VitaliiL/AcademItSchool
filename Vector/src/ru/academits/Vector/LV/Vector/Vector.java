package ru.academits.Vector.LV.Vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorValues;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("It isn't correct vector's size.");
        } else {
            this.vectorValues = new double[vectorSize];
        }
    }

    public Vector(Vector vector) {
        this.vectorValues = Arrays.copyOf(vector.vectorValues, vector.vectorValues.length);
    }

    public Vector(double[] vectorValues) {
        if (vectorValues.length == 0) {
            throw new IllegalArgumentException("Vector size length is zero.");
        } else {
            this.vectorValues = Arrays.copyOf(vectorValues, vectorValues.length);
        }
    }

    public Vector(int n, double[] vectorValues) {
        if (n <= 0 || vectorValues.length == 0) {
            throw new IllegalArgumentException("It isn't correct values.");
        } else {
            this.vectorValues = Arrays.copyOf(vectorValues, n);
        }
    }

    public int getSize() {
        return vectorValues.length;
    }



}
