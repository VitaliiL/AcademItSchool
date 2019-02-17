package ru.academits.ArrayListHome.LV.deleteDuplicate;

import java.util.ArrayList;
import java.util.List;

public class CheckDuplicate {
    public List<Integer> removeDuplicate(List<Integer> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("Your file doesn't have any values.");
        }

        List<Integer> list2 = new ArrayList<>();

        for (Integer element : list) {
            if (!list2.contains(element)) {
                list2.add(element);
            }
        }

        return list2;
    }
}

