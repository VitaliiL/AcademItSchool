package ru.academits.lapshakov.Range_task.range;

import java.util.*;

public class RangeActions {
    private ArrayList<Double> list1;
    private ArrayList<Double> list2;

    public RangeActions(ArrayList<Double> list1, ArrayList<Double> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }


    public ArrayList<Double> getUnionRangeResult() {
        list1.removeAll(list2);
        list1.addAll(list2);

        return list1;
    }


    public ArrayList<Double> getIntersectionRangeResult() {
        for (Double element : list1) {
            if (list2.contains(element)) {
                list1.retainAll(list2);

                return list1;
            }
        }

        return null;
    }


    public ArrayList<Double> getDifferenceRangeResult() {
        list1.removeAll(list2);

        return list1;
    }
}

