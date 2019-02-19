package ru.academits.ArrayListHome.LV.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrayListHome = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\vlaps\\IdeaProjects\\academits\\ArrayListHome\\src\\ForArrayListHome"))) {
            while (scanner.hasNextLine()) {
                arrayListHome.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        }

        ArrayList<Integer> arrayListHome2 = new ArrayList<>(Arrays.asList(1, 3, 1, 5, 7, 2, 9, 4, 7, 2));
        ArrayList<Integer> arrayListHome3 = new ArrayList<>(Arrays.asList(1, 3, 1, 5, 7, 2, 9, 4, 7, 2));

        System.out.println(arrayListHome);
        System.out.println(removeEven(arrayListHome2));
        System.out.println(removeDuplicate(arrayListHome3));
    }

    private static ArrayList removeEven(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }

    private static ArrayList removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
