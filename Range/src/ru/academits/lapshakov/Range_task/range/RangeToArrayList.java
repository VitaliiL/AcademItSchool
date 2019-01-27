package ru.academits.lapshakov.Range_task.range;

import java.util.*;

public class RangeToArrayList {
    private double from;
    private double to;

    public RangeToArrayList(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getIntervalLength() {
        return to - from;
    }

    public ArrayList<Double> getArrayList(double from, double to) {
        double[] array = new double[(int) (to - from + 1)];

        for (int i = 0; i < array.length; i++) {
            array[i] = from;
            from++;
        }

        ArrayList<Double> list = new ArrayList<>();

        for (Double element : array) {
            list.add(element);
        }

        return list;
    }
}

