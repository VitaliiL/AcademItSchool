package ru.academits.Lambda.LV.main;

import ru.academits.Lambda.LV.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> person = Arrays.asList(
                new Person("Alisa", 14),
                new Person("Bob", 16),
                new Person("Mike", 34),
                new Person("Jenny", 28),
                new Person("Simon", 15),
                new Person("Met", 42),
                new Person("Jenny", 39),
                new Person("Bob", 44),
                new Person("Alisa", 17));

        List<String> nameList = person
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique name list: " + nameList);

        System.out.println("Names: " + person
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ")));

        List<String> personLess18 = person
                .stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Person list less 18 years: " + personLess18);

        OptionalDouble averageAge = person
                .stream()
                .mapToDouble(Person::getAge)
                .filter(age -> age < 18)
                .average();

        if (averageAge.isPresent()) {
            System.out.println("Average age of person list less 18 years: " + averageAge.getAsDouble());
        }

        Map<String, Double> personsByAverAge = person
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println("Average age of persons: " + personsByAverAge);

        System.out.println("Persons from 20 to 45: " + person
                .stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))
                .map(Person::getName)
                .collect(Collectors.joining(", ")));
    }
}
