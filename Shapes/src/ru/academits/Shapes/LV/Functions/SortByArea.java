package ru.academits.Shapes.LV.Functions;

import ru.academits.Shapes.LV.Interfaces.Shape;

import java.util.Comparator;
import java.util.List;

public class SortByArea implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) o1.getArea() - (int) o2.getArea();
    }

}
