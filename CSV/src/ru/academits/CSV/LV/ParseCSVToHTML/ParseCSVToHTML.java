package ru.academits.CSV.LV.ParseCSVToHTML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ParseCSVToHTML {
    private static final String DOCTYPE = "<!DOCTYPE html>";
    private static final String HTMLLANG = "<html lang=\"en\">";
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

    public static void parseCSV(String fileOut, String fileIn) {
        try (Scanner scanner = new Scanner(new FileInputStream(fileOut));
             PrintWriter writer = new PrintWriter(fileIn)) {

            if (!scanner.hasNextLine()) {
                System.out.println("File is empty.");
            }

            StringBuilder tableToHtml = new StringBuilder();
            tableToHtml.append(DOCTYPE).append(HTMLLANG).append(HEAD).append(META).append(TITLE).append(HEAD_CLOSE).append(BODY)
                    .append(TABLE).append(System.lineSeparator());

            boolean isQuote = false;

            while (scanner.hasNextLine()) {
                if (!isQuote) {
                    tableToHtml.append(ROW).append(CELL);
                }

                String line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (symbol == QUOTE) {
                        if (i == line.length() - 1) {
                            isQuote = !isQuote;
                        } else if (line.charAt(i + 1) == QUOTE && isQuote) {
                            tableToHtml.append(symbol);
                            i++;
                        } else {
                            isQuote = !isQuote;
                        }
                    } else if (symbol == SEPARATE) {
                        if (isQuote) {
                            tableToHtml.append(SEPARATE);
                        } else {
                            tableToHtml.append(CELL_CLOSE).append(CELL);
                        }
                    }
                }

                if (isQuote) {
                    tableToHtml.append(BREAK);
                } else {
                    tableToHtml.append(CELL_CLOSE).append(ROW_CLOSE);
                }
            }

            tableToHtml.append(TABLE_CLOSE).append(BODY_CLOSE).append(HTML_CLOSE);
            writer.print(tableToHtml.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Your file not found.");
        }
    }
}