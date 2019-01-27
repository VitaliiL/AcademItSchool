package ru.academits.lapshakov.Main;

import ru.academits.lapshakov.RangeTaskOnceMore.Range;
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

        Range firstInterval = new Range(from, to);
        Range secondInterval = new Range(from2, to2);

        //Range lengths:
        System.out.printf("The first interval length: %.2f%n", firstInterval.getIntervalLength());
        System.out.printf("The second interval length: %.2f%n%n", secondInterval.getIntervalLength());

        //isInside:
        System.out.printf("The value belongs the first interval: %b%n", firstInterval.isInsideInterval(value));
        System.out.printf("The value belongs the second interval: %b%n%n", secondInterval.isInsideInterval(value));

        //Range intersection:
        Range intersectionRange = firstInterval.getIntersectionRangeResult(secondInterval);

        if (intersectionRange != null) {
            System.out.printf("The range intersection array result: {%s%s%s}%n", intersectionRange.getFrom(), ",...,", intersectionRange.getTo());
        } else {
            System.out.println("There are no any intersection.");
        }

        //Range union:
        Range[] unionRange = firstInterval.getUnionRangeResult(secondInterval);

        if (unionRange.length == 1) {
            System.out.printf("The range union array result: {%s%s%s}%n", unionRange[0].getFrom(), ",...,", unionRange[0].getTo());
        } else {
            System.out.printf("The range union1 array result: {%s%s%s%s%s%s}%n%n", unionRange[0].getFrom(), ",...,", unionRange[0].getTo(), unionRange[1].getFrom(), ",...,", unionRange[1].getTo());
        }

        //Range difference:
        Range[] differenceRange = firstInterval.getUnionRangeResult(secondInterval);

        if (unionRange.length == 1) {
            System.out.printf("The range difference array result: {%s%s%s}%n", differenceRange[0].getFrom(), ",...,", differenceRange[0].getTo());
        } else {
            System.out.printf("The range difference array result: {%s%s%s%s%s%s}%n", differenceRange[0].getFrom(),",...,", differenceRange[0].getTo(), differenceRange[1].getFrom(), ",...,", differenceRange[1].getTo());
        }
    }
}

