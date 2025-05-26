package com.prac.core.problem.companies.capgemini.may2025;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintByCity {
    public static void main(String[] args) {
        BiConsumer<String, List<Person>> PrintByCity = (a, b) -> System.out.println("Persons from the City " + a + " are [" + b.stream().map(Person::getName).collect(Collectors.joining(", ")) + "]");

        List<Person> list = Arrays.asList(new Person("A", "Pune"), new Person("B", "Amaravathi"), new Person("C", "Chennai"),
                new Person("D", "Pune"), new Person("E", "Amaravathi"), new Person("F", "Chennai"));

        Map<String, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getCity));

        map.entrySet().stream().forEach(e -> PrintByCity.accept(e.getKey(), e.getValue()));

        /* Syntax of anyMatch */
        Predicate<Integer> integerPredicate = i -> i % 2 == 0;
        boolean b = Stream.iterate(1, n -> n + 1)
                .limit(10)
                .peek(System.out::println)
                .anyMatch(integerPredicate);
        System.out.println(b);

        // Creating a list of Integers
        List<Integer> integerList = Arrays.asList(3, 4, 6, 12, 20);

        // Stream anyMatch(Predicate predicate)
        boolean answer = integerList.stream().anyMatch(n -> (n * (n + 1)) / 4 == 5);

        // Displaying the result
        System.out.println("stream().anyMatch :: "+answer);
    }
}
