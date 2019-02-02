package ru.academits.Shapes.LV.Main;

import ru.academits.Shapes.LV.Functions.SortByArea;
import ru.academits.Shapes.LV.Functions.SortByPerimeter;
import ru.academits.Shapes.LV.Interfaces.Shape;
import ru.academits.Shapes.LV.Shapes.Circle;
import ru.academits.Shapes.LV.Shapes.Rectangle;
import ru.academits.Shapes.LV.Shapes.Square;
import ru.academits.Shapes.LV.Shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(4));
        shapes.add(new Triangle(2.5, 3, -1.5, -2, 4, 3.5));
        shapes.add(new Rectangle(2, 7));
        shapes.add(new Circle(5));
        shapes.add(new Square(9.8));
        shapes.add(new Triangle(-1, -3.4, 10, 1.2, 1, 1.9));


        Shape maxAreaShape = getMaxArea(shapes);
        System.out.printf("Shape with max area is in the %s and its area is %.4s (inputted data: width is %s and height is %s.)%n", maxAreaShape.getClass().toString(), maxAreaShape.getArea(), maxAreaShape.getWidth(), maxAreaShape.getHeight());

        Shape secondMaxPerimeterShape = getSecondMaxPerimeter(shapes);
        System.out.printf("Shape with max area is in the %s and its area is %.4s (inputted data: width is %s and height is %s.)", secondMaxPerimeterShape.getClass().toString(), secondMaxPerimeterShape.getArea(), secondMaxPerimeterShape.getWidth(), secondMaxPerimeterShape.getHeight());
    }


    private static Shape getMaxArea(List<Shape> shapes) {
        shapes.sort(new SortByArea());

        return shapes.get(shapes.size() - 1);
    }

    private static Shape getSecondMaxPerimeter(List<Shape> shapes) {
        shapes.sort(new SortByPerimeter());

        return shapes.get(shapes.size() - 2);
    }
}

