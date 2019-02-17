package ru.academits.ArrayListHome.LV.main;

import ru.academits.ArrayListHome.LV.deleteDuplicate.CheckDuplicate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> arrayListHome = new ArrayList<>();
            ArrayList<Integer> arrayListHome2 = new ArrayList<>();

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

            arrayListHome.removeIf(element -> element % 2 == 0);
            System.out.println(arrayListHome);

            ArrayList<Integer> arrayListHome3 = new CheckDuplicate().removeDuplicate(arrayListHome2);
            System.out.println(arrayListHome3);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please check: " + e.getMessage());
        }
    }
}


