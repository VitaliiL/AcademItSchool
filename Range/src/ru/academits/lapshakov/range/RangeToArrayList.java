package ru.academits.lapshakov.range;

import java.util.*;

class RangeToArrayList {
    private double from;
    private double to;

    RangeToArrayList(double from, double to) {
        this.from = from;
        this.to = to;
    }

    double getIntervalLength() {
        return to - from;
    }

    ArrayList<Double> getArrayList(double from, double to) {
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

