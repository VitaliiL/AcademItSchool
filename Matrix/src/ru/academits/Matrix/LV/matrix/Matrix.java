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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        for (Vector component : row) {
            s.append(component.toString()).append(", ");
        }

        s.setLength(s.length() - 2);
        s.append("}");

        return s.toString();
    }

}
