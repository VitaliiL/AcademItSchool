package ru.academits.ArrayListHome.LV.deleteDuplicate;

import java.util.ArrayList;

public class CheckDuplicate {
    public ArrayList<Integer> removeDuplicate(ArrayList<Integer> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("Your file doesn't have any values.");
        }

        ArrayList<Integer> list2 = new ArrayList<>();

        for (Integer element : list) {
            if (!list2.contains(element)) {
                list2.add(element);
            }
        }

        return list2;
    }
}

