package ru.academits.CSV.LV.FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFile() {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\vlaps\\IdeaProjects\\academits\\Excel.csv"))) {
            if (!scanner.hasNextLine()) {
                System.out.println("File is empty.");
            }

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        }

        return list;
    }

    public static void writeFile(StringBuilder sb) {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\vlaps\\IdeaProjects\\academits\\HTML.html")) {
            writer.print(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        }
    }
}