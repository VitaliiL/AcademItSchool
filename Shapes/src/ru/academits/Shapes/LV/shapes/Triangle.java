package ru.academits.Shapes.LV.shapes;

import ru.academits.Shapes.LV.interfaces.Shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double getTriangleSideLength(double a, double b, double c, double d) {
        return Math.sqrt(Math.pow((b - a), 2) + Math.pow((d - c), 2));
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        return Math.abs(((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) / 2);
    }

    @Override
    public double getPerimeter() {
        double sideAB = getTriangleSideLength(x1, x2, y1, y2);
        double sideAC = getTriangleSideLength(x1, x3, y1, y3);
        double sideBC = getTriangleSideLength(x2, x3, y2, y3);

        return sideAB + sideAC + sideBC;
    }

    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }
        if (s == null || getClass() != s.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) s;

        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }

    @Override
    public String toString() {
        return "x1 = " + x1 + "x2 = " + x2 + "x3 = " + x3 + "y1 = " + y1 + "y2 = " + y2 + "y3 = " + y3;
    }
}
