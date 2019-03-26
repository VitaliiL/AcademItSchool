package ru.academits.Lambda.LV.main;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainSecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the value:");
        int value = scanner.nextInt();

        IntStream
                .iterate(1, element -> element + 1)
                .mapToDouble(Math::sqrt)
                .limit(value)
                .forEach(System.out::println);
    }
}
