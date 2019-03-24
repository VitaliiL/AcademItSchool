package ru.academits.ArrayList.LV.main;

import ru.academits.ArrayList.LV.arrayList.MyArrayList;

public class Main {
    public static void main(String[] args) {
        //check constructors:
        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>(3);

        System.out.println("Check increase capacity list2: " + list2.getCapacity());
        System.out.println("<After filling>:");

        for (int i = 0, j = 1; i < 11; i++, j++) {
            list1.add(i, j);
            list2.add(i, j);
        }

        System.out.println("Check size list1: " + list1.size());
        System.out.println("Check array if it is empty list1: " + list1.isEmpty());

        System.out.println("Check add by index list" + list1);
        System.out.println("Check increase capacity list1: " + list1.getCapacity());
        System.out.println("Check increase capacity list2: " + list2.getCapacity());

        System.out.println();

        System.out.println("Check remove element by index: " + list1.remove(3));
        System.out.println("Check remove from list1: " + list1);
    }
}
