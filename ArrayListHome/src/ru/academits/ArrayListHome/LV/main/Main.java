package ru.academits.ArrayListHome.LV.main;

import ru.academits.ArrayListHome.LV.deleteDuplicate.CheckDuplicate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> arrayListHome = new ArrayList<>();
            List<Integer> arrayListHome2 = new ArrayList<>();

            Scanner scanner = new Scanner(new File("ForArrayListHome.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                for (String element : values) {
                    arrayListHome.add(Integer.parseInt(element));
                    arrayListHome2.add(Integer.parseInt(element));
                }
            }

            System.out.println(arrayListHome);

            arrayListHome = new LinkedList<>();
            arrayListHome.removeIf(element -> element % 2 == 0);
            System.out.println(arrayListHome);

            List<Integer> arrayListHome3 = new CheckDuplicate().removeDuplicate(arrayListHome2);
            System.out.println(arrayListHome3);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please check: " + e.getMessage());
        }
    }
}


