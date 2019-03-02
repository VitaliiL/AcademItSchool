package ru.academits.CSV.LV.Main;

import ru.academits.CSV.LV.FileReader.FileReader;

import java.util.ArrayList;

public class Main {
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

    public static void main(String[] args) {
        ArrayList<String> list = FileReader.readFile();

        StringBuilder tableToHtml = new StringBuilder();
        tableToHtml.append(DOCTYPE).append(HTMLLANG).append(HEAD).append(META).append(TITLE).append(HEAD_CLOSE).append(BODY)
                .append(TABLE).append(ROW).append(System.lineSeparator());

        System.out.println(list); // for test

        for (String element : list) {

            for (int i = 0; i < element.length(); i++) {
                char symbol = element.charAt(i);

                if (symbol == QUOTE) {


                }
            }
        }

        tableToHtml.append(TABLE_CLOSE).append(BODY_CLOSE).append(HTML_CLOSE);
        FileReader.writeFile(tableToHtml);
    }
}

