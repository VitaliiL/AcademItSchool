package ru.academits.Range.LV.Main;

import ru.academits.Range.LV.Range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the start value of range:");
        double from = scanner.nextDouble();
        System.out.println("Input the end value of range:");
        double to = scanner.nextDouble();

        System.out.println("Input the start value of the second range:");
        double from2 = scanner.nextDouble();
        System.out.println("Input the end value of the second range:");
        double to2 = scanner.nextDouble();

        System.out.println("Input to check value:");
        double value = scanner.nextDouble();

        Range first = new Range(from, to);
        Range second = new Range(from2, to2);

        //Range lengths:
        System.out.printf("The first interval length: %.2f%n", first.getLength());
        System.out.printf("The second interval length: %.2f%n%n", second.getLength());

        //isInside:
        System.out.printf("The value belongs the first interval: %b%n", first.isInside(value));
        System.out.printf("The value belongs the second interval: %b%n%n", second.isInside(value));

        //Range intersection:
        Range intersection = first.getIntersection(second);

        if (intersection != null) {
            System.out.printf("The range intersection array result: {%s%s%s}%n", intersection.getFrom(), ",...,", intersection.getTo());
        } else {
            System.out.println("There is no intersection.");
        }


        //Range union:
        Range[] unionRange = first.getUnion(second);

        if (unionRange.length == 1) {
            System.out.printf("The range union array result: {%s%s%s}%n", unionRange[0].getFrom(), ",...,", unionRange[0].getTo());
        } else {
            System.out.printf("The range union1 array result: {%s%s%s%s%s%s%s}%n", unionRange[0].getFrom(), ",...,", unionRange[0].getTo(), "} and {", unionRange[1].getFrom(), ",...,", unionRange[1].getTo());
        }

        //Range difference:
        Range[] difference = first.getDifference(second);

        if (difference.length == 1) {
            System.out.printf("The range difference array result: {%s%s%s}%n", difference[0].getFrom(), ",...,", difference[0].getTo());
        } else if (difference.length == 2) {
            System.out.printf("The range difference array result: {%s%s%s%s%s%s%s}%n", difference[0].getFrom(), ",...,", difference[0].getTo(), "} and {", difference[1].getFrom(), ",...,", difference[1].getTo());
        } else {
            System.out.println("Difference result is null.");
        }
    }
}

