package ru.academits.Shapes.LV.shapes;

import ru.academits.Shapes.LV.interfaces.Shape;

public class Rectangle implements Shape {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getWidth() {
        return side1;
    }

    @Override
    public double getHeight() {
        return side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }
        if (s == null || getClass() != s.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) s;

        return side1 == rectangle.side1 && side2 == rectangle.side2;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side1);
        hash = prime * hash + Double.hashCode(side2);

        return hash;
    }

    @Override
    public String toString() {
        return "side1 = " + side1 + "side2 = " + side2;
    }
}
