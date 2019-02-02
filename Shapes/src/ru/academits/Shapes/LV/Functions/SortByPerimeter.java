package ru.academits.Shapes.LV.Functions;

import ru.academits.Shapes.LV.Interfaces.Shape;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) o1.getPerimeter() - (int) o2.getPerimeter();
    }
}

