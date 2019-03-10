package ru.academits.List.LV.list.main;


import ru.academits.List.LV.list.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addByIndex(0, 5);
        list.addToTop(7);
        //list.removeByIndex(1);
        list.addByIndex(1, 6);
       // list.addByIndex(2, 6);
       // list.addByIndex(0, 7);

        //list.addToTop(9);


        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.getByIndex(0));
        System.out.println(list.getFirstElement());
        System.out.println(list.removeFirstElement());
        System.out.println(list);

    }
}
