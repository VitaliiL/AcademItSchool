package ru.academits.CSV.LV.Main;

import ru.academits.CSV.LV.ParseCSVToHTML.ParseCSVToHTML;

public class Main {
    public static void main(String[] args) {
        try {
            ParseCSVToHTML.parseCSV("C:\\Users\\vlaps\\IdeaProjects\\academits\\123.csv", "C:\\Users\\vlaps\\IdeaProjects\\academits\\HTML.html");
        } catch (IllegalArgumentException e) {
            System.out.println("Need two directories: source is CSV file and destination is HTML file.");
        }
    }
}