package main;

import ru.academits.CSV.LV.parseCSVToHTML.ParseCSVToHTML;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You should input 2 paths in the program arguments: source is CSV file and destination is HTML file.");
        } else {
            ParseCSVToHTML.parseCSV(args[0], args[1]);
        }
    }
}
