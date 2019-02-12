package ru.academits.Vector.LV.Vector;


import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("It isn't correct vector's size.");
        }

        components = new double[vectorSize];
    }

    private Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] vectorValues) {
        if (vectorValues.length == 0) {
            throw new IllegalArgumentException("Vector size length is zero.");
        }

        components = Arrays.copyOf(vectorValues, vectorValues.length);
    }

    public Vector(int n, double[] vectorValues) {
        if (n <= 0) {
            throw new IllegalArgumentException("It isn't correct value.");
        }

        components = Arrays.copyOf(vectorValues, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        for (double component : components) {
            s.append(component);
            s.append(", ");
        }

        s.delete(s.length() - 2, s.length());
        s.append("}");

        return s.toString();
    }

    public Vector addToVector(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public Vector subtractFromVector(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector multiplyByScalar(int scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector reverseVector() {
        multiplyByScalar(-1);

        return this;
    }

    public int getLength() {
        return getSize();
    }

    public void setComponentByIndex(int index, double value) {
        if (index >= components.length || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the vector.");
        }

        components[index] = value;
    }

    public double getComponentByIndex(int index) {
        return components[index];
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

        for (int i = 0; i < components.length; i++) {
            if (this.components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector sumResult = new Vector(vector1);

        return sumResult.addToVector(vector2);
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector subtractionResult = new Vector(vector1);

        return subtractionResult.subtractFromVector(vector2);
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        double multiplicationResult = 0;
        double minSize = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minSize; i++) {
            multiplicationResult += vector1.components[i] * vector2.components[i];
        }

        return multiplicationResult;

    }

}
