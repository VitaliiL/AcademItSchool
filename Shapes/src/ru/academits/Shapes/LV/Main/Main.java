package ru.academits.Shapes.LV.Main;

import ru.academits.Shapes.LV.Shapes.Circle;
import ru.academits.Shapes.LV.Shapes.Rectangle;
import ru.academits.Shapes.LV.Shapes.Square;
import ru.academits.Shapes.LV.Shapes.Triangle;

import java.awt.geom.Area;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(4.3);
        Triangle triangle = new Triangle(2.5, 3, -1.5, -2, 4, 3.5);
        Rectangle rectangle = new Rectangle(2, 7);
        Circle circle = new Circle(5);

        Square square2 = new Square(9.8);
        Triangle triangle2 = new Triangle(-1, -3.4, 10, 1.2, 1, 1.9);
        Rectangle rectangle2 = new Rectangle(2.8, 4);
        Circle circle2 = new Circle(1.9);



    }
}
