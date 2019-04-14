package main;

import myHashTable.MyHashTable;

public class Main {
    public static void main(String[] args) {

        MyHashTable<Integer> hashTable1 = new MyHashTable<>();
        MyHashTable<Integer> hashTable2 = new MyHashTable<>(20);

        System.out.println("Default table size is: " + hashTable1.size());
        System.out.println("Setting table size is: " + hashTable2.size() + "\n");


    }
}
