package ru.academits.Lambda.LV.main;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class MainSecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the value:");
        int value = scanner.nextInt();


        DoubleStream
                .iterate(1, element -> element + 1)
                .map(Math::sqrt)
                .limit(value)
                .forEach(System.out::println);
    }
}
