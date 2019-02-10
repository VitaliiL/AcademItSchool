package ru.academits.Vector.LV.Vector;


import java.util.Arrays;

public class Vector {
    private double[] vectorValues;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("It isn't correct vector's size.");
        } else {
            vectorValues = new double[vectorSize];
        }
    }

    private Vector(Vector vector) {
        vectorValues = Arrays.copyOf(vector.vectorValues, vector.vectorValues.length);
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
            throw new IllegalArgumentException("It isn't correct value.");
        } else {
            this.vectorValues = Arrays.copyOf(vectorValues, n);
        }
    }

    public int getSize() {
        return vectorValues.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        for (int i = 0; i < vectorValues.length; i++) {
            s.append(vectorValues[i]);

            if (i < vectorValues.length - 1) {
                s.append(",");
            }
        }

        s.append("}");

        return s.toString();
    }

    public Vector addToVector(Vector vector) {
        if (vectorValues.length < vector.vectorValues.length) {
            vectorValues = Arrays.copyOf(vectorValues, vector.vectorValues.length);
        }

        for (int i = 0; i < vector.vectorValues.length; i++) {
            vectorValues[i] += vector.vectorValues[i];
        }

        return this;
    }

    public Vector getSubtractionFromVector(Vector vector) {
        if (vectorValues.length < vector.vectorValues.length) {
            vectorValues = Arrays.copyOf(vectorValues, vector.vectorValues.length);
        }

        for (int i = 0; i < vector.vectorValues.length; i++) {
            vectorValues[i] -= vector.vectorValues[i];
        }

        return this;
    }

    public Vector getMultiplicationScalar(int scalar) {
        for (int i = 0; i < vectorValues.length; i++) {
            vectorValues[i] *= scalar;
        }

        return this;
    }

    public Vector getVectorReverse() {
        getMultiplicationScalar(-1);

        return this;
    }

    public int getVectorLength() {
        return getSize();
    }

    public double getComponentVector(int index, double value) {
        if (index >= vectorValues.length || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the vector.");
        }

        vectorValues[index] = value;

        return vectorValues[index];
    }

    @Override
    public boolean equals(Object v) {
        if (this == v) {
            return true;

        }

        if (v == null || getClass() != v.getClass()) {
            return false;
        }

        Vector vector = (Vector) v;

        if (this.getSize() != vector.getSize()) {
            return false;
        }

        for (int i = 0; i < vectorValues.length; i++) {
            if (this.vectorValues[i] != vector.vectorValues[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectorValues);

        return hash;
    }

    public static Vector getSumVectors(Vector vector1, Vector vector2) {
        Vector vectorSumResult = new Vector(vector1);

        return vectorSumResult.addToVector(vector2);
    }

    public static Vector getSubtractionVectors(Vector vector1, Vector vector2) {
        Vector vectorSumResult = new Vector(vector1);

        return vectorSumResult.getSubtractionFromVector(vector2);
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        double vectorScalarMultiplicationResult = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); i++) {
            vectorScalarMultiplicationResult += vector1.vectorValues[i] * vector2.vectorValues[i];
        }

        return vectorScalarMultiplicationResult;

    }

}
