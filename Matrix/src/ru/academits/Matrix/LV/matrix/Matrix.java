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
            throw new IndexOutOfBoundsException("Length is 0.");
        }

        row = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            row[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectorArray) {
        if (vectorArray.length == 0) {
            throw new IndexOutOfBoundsException("Length is 0.");
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

    public int getRowsAmount(){
        return row.length;
    }

    public int getColumnsAmount(){
        return row[0].getSize();
    }

    public void setRowByIndex(int index, Vector vector) {
        checkIndex(index);


    }

  //  public Vector getRowByIndex(int index) {
  //      checkIndex(index);

//
    private void checkIndex(int index) {
        if (index >= getRowsAmount() || index >= getColumnsAmount() || index < 0) {
            throw new IndexOutOfBoundsException("Value with this index isn't existing in the matrix.");
        }
    }



}
