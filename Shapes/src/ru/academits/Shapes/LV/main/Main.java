package ru.academits.Shapes.LV.main;

import ru.academits.Shapes.LV.functions.ShapeAreaSortComparator;
import ru.academits.Shapes.LV.functions.ShapePerimeterSortComparator;
import ru.academits.Shapes.LV.interfaces.Shape;
import ru.academits.Shapes.LV.shapes.Circle;
import ru.academits.Shapes.LV.shapes.Rectangle;
import ru.academits.Shapes.LV.shapes.Square;
import ru.academits.Shapes.LV.shapes.Triangle;

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

        Shape maxAreaShape = getMaxAreaShape(shapes);
        System.out.printf("Shape with max area is in the %s and its area is %.4s (inputted data: width is %s and height is %s.)%n",
                maxAreaShape.getClass().toString(), maxAreaShape.getArea(), maxAreaShape.getWidth(), maxAreaShape.getHeight());

        Shape secondMaxPerimeterShape = getSecondMaxPerimeterShape(shapes);
        System.out.printf("Shape with max area is in the %s and its area is %.4s (inputted data: width is %s and height is %s.)",
                secondMaxPerimeterShape.getClass().toString(), secondMaxPerimeterShape.getArea(), secondMaxPerimeterShape.getWidth(), secondMaxPerimeterShape.getHeight());
    }

    private static Shape getMaxAreaShape(List<Shape> shapes) {
        shapes.sort(new ShapeAreaSortComparator());

        return shapes.get(shapes.size() - 1);
    }

    private static Shape getSecondMaxPerimeterShape(List<Shape> shapes) {
        shapes.sort(new ShapePerimeterSortComparator());

        return shapes.get(shapes.size() - 2);
    }
}

