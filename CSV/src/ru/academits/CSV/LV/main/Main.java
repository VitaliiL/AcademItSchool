package ru.academits.CSV.LV.main;

import ru.academits.CSV.LV.parseCSVToHTML.ParseCSVToHTML;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("You should input 2 paths in the program arguments: source is CSV file and destination is HTML file.");
            }

            ParseCSVToHTML.parseCSV(args[0], args[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("Check please. " + e.getMessage());
        }
    }
}