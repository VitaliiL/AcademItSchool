package ru.academits.CSV.LV.parseCSVToHTML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ParseCSVToHTML {
    private static final String DOCTYPE = "<!DOCTYPE html>";
    private static final String HTML_LANG = "<html lang=\"en\">";
    private static final String HEAD = "<head>";
    private static final String HEAD_CLOSE = "</head>";
    private static final String META = "<meta charset=\"UTF-8\">";
    private static final String TITLE = "<title>Parsing CSV to HTML</title>";
    private static final String BODY = "<body>";
    private static final String BODY_CLOSE = "</body>";
    private static final String TABLE = "<table>";
    private static final String TABLE_CLOSE = "</table>";
    private static final String ROW = "<tr>";
    private static final String ROW_CLOSE = "</tr>";
    private static final String CELL = "<td>";
    private static final String CELL_CLOSE = "</td>";
    private static final String BREAK = "<br/>";
    private static final String HTML_CLOSE = "</html>";
    private static final char SEPARATE = ',';
    private static final char QUOTE = '"';


    public static void parseCSV(String fileCSV, String fileHTML) {
        try (Scanner scanner = new Scanner(new FileInputStream(fileCSV));
             PrintWriter writer = new PrintWriter(fileHTML)) {

            if (!scanner.hasNextLine()) {
                System.out.println("File is empty.");
            }

            writer.println(DOCTYPE);
            writer.println(HTML_LANG);
            writer.println(HEAD);
            writer.println(META);
            writer.println(TITLE);
            writer.println(HEAD_CLOSE);
            writer.println(BODY);
            writer.println(TABLE);

            boolean isQuote = false;

            while (scanner.hasNextLine()) {
                if (!isQuote) {
                    writer.println(ROW);
                    writer.print(CELL);
                }

                String line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (symbol == QUOTE) {
                        if (i == line.length() - 1) {
                            isQuote = !isQuote;
                        } else if (line.charAt(i + 1) == QUOTE && isQuote) {
                            writer.print(symbol);
                            i++;
                        } else {
                            isQuote = !isQuote;
                        }
                    } else if (symbol == SEPARATE) {
                        if (isQuote) {
                            writer.print(SEPARATE);
                        } else {
                            writer.print(CELL_CLOSE);
                            writer.print(CELL);
                        }
                    } else if (symbol == '<') {
                        writer.print("&lt;");
                    } else if (symbol == '>') {
                        writer.print("&gt;");
                    } else if (symbol == '&') {
                        writer.print("&amp;");
                    } else {
                        writer.print(symbol);
                    }
                }

                if (isQuote) {
                    writer.print(BREAK);
                } else {
                    writer.println(CELL_CLOSE);
                    writer.println(ROW_CLOSE);
                }
            }

            writer.println(TABLE_CLOSE);
            writer.println(BODY_CLOSE);
            writer.println(HTML_CLOSE);
        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        }
    }
}