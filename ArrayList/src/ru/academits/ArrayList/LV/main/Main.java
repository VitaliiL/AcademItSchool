package ru.academits.ArrayList.LV.main;

import ru.academits.ArrayList.LV.arrayList.MyArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //check constructors:
        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>(3);

        //check methods:
        System.out.println("Check increase capacity list2: " + list2.getCapacity());
        System.out.println("<After filling>:");

        for (int i = 0, j = 1; i < 11; i++, j++) {
            list1.add(i, j);
            list2.add(i, j);
        }

        list1.add(11, 3);
        list1.add(5);

        System.out.println("Check size list1: " + list1.size());
        System.out.println("Check array if it is empty list1: " + list1.isEmpty());

        System.out.println("Check add by index list: " + list1);
        System.out.println("Check add: " + list1.add(7) + " -> " + list1);
        System.out.println("Check increase capacity list1: " + list1.getCapacity());
        System.out.println("Check increase capacity list2: " + list2.getCapacity() + "\n");

        System.out.println("Check remove element by index: " + list1.remove(3) + " -> " + list1);
        System.out.println("Check remove by element: " + list1.remove(Integer.valueOf(5)) + " -> " + list1);

        list1.trimToSize();
        System.out.println("Check capacity after trimToSize: " + list1.getCapacity());
        list1.ensureCapacity(20);
        System.out.println("Check capacity after ensureCapacity: " + list1.getCapacity() + "\n");
        System.out.println("Check contains: " + list1.contains(3));

        Object[] array = list1.toArray();
        System.out.println("Check to Array methods: " + Arrays.toString(array));

        System.out.println("Check the first occurrence: " + list1.indexOf(3));
        System.out.println("Check the latest occurrence: " + list1.lastIndexOf(3) + "\n");

        MyArrayList<Integer> listAddition = new MyArrayList<>();
        listAddition.add(22);
        listAddition.add(33);

        System.out.println("Check addAll by index: " + list1.addAll(1, listAddition) + " -> " + list1);
        System.out.println("Check addAll: " + list1.addAll(list2) + " -> " + list1 + "\n");
        System.out.println("Check containsAll: " + list1.containsAll(listAddition));

        System.out.println(list1);
        System.out.println(list2);
        System.out.println("Check retainAll: " + list1.retainAll(list2) + "->" + list1);
        System.out.println("Check removeAll: " + list2.removeAll(list1) + "->" + list2 + "\n");

        list1.clear();
        System.out.println("Clear list1: " + list1);
    }
}
