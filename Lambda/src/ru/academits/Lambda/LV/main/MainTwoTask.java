package ru.academits.Lambda.LV.main;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainTwoTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the value:");
        int value = scanner.nextInt();

        IntStream
                .iterate(1, element -> element + 1)
                .takeWhile(element -> element <= value)
                .mapToDouble(element -> Math.pow(element, 0.5))
                .forEach(System.out::println);
    }
}
