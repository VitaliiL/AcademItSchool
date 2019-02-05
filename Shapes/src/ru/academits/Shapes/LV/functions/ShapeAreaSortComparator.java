package ru.academits.Shapes.LV.functions;

import ru.academits.Shapes.LV.interfaces.Shape;

import java.util.Comparator;

public class ShapeAreaSortComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
