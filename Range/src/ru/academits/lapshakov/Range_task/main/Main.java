package ru.academits.lapshakov.Range_task.main;

import ru.academits.lapshakov.Range_task.range.RangeActions;
import ru.academits.lapshakov.Range_task.range.RangeToArrayList;

import java.util.*;

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

        RangeToArrayList firstInterval = new RangeToArrayList(from, to);
        RangeToArrayList secondInterval = new RangeToArrayList(from2, to2);

        //Range lengths:
        System.out.printf("The first interval length %.2f%n", firstInterval.getIntervalLength());
        System.out.printf("The second interval length %.2f%n%n", secondInterval.getIntervalLength());

        //Range union:
        ArrayList<Double> list1 = firstInterval.getArrayList(from, to);
        ArrayList<Double> list2 = secondInterval.getArrayList(from2, to2);

        RangeActions unionRangeResult = new RangeActions(list1, list2);
        System.out.printf("Union range result: %s%n", unionRangeResult.getUnionRangeResult());


        //Range intersection:
        ArrayList<Double> list3 = firstInterval.getArrayList(from, to);
        ArrayList<Double> list4 = secondInterval.getArrayList(from2, to2);

        RangeActions intersectionRangeResult = new RangeActions(list3, list4);
        System.out.printf("Intersection range result: %s%n", intersectionRangeResult.getIntersectionRangeResult());

        //Range difference:
        ArrayList<Double> list5 = firstInterval.getArrayList(from, to);
        ArrayList<Double> list6 = secondInterval.getArrayList(from2, to2);

        RangeActions differenceRangeResult = new RangeActions(list5, list6);
        System.out.printf("Difference range result: %s%n", differenceRangeResult.getDifferenceRangeResult());

    }
}