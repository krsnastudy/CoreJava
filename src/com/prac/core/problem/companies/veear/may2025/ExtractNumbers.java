package com.prac.core.problem.companies.veear.may2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractNumbers {
    public static void main(String[] args) {
        String abc = "a12x56789w23456z9k6598t325";

//        String[] numbers = abc.split("[^0-9]+"); // Split by non-digit characters
        String[] numbers = abc.split("[\\D]+"); // Split by non-digit characters

        for (String num : numbers) {
            if (!num.isEmpty()) {
                System.out.println(num);
            }
        }

        System.out.println("\nLength: " + numbers.length);
        System.out.println("Empty Strings ");
        String collect2 = Arrays.stream(numbers).filter(s -> s.isEmpty()).map(m -> "***").collect(Collectors.joining(", "));
        System.out.println(collect2);
        System.out.println();

        List<Integer> collect1 = Arrays.stream(numbers)
//                .peek(System.out::println)
                .filter(s -> !s.isEmpty())
                .map(m -> m.trim())
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Method 1 :: " + collect1);

        List<Integer> collect = Arrays.stream(abc.split("[^0-9]+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Method 2 :: " + collect);

        Integer max = collect.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("Max: " + max);

        int maxValue = Arrays.stream(numbers)
                .filter(f -> !f.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream().sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList())
                .stream().findFirst().get();
//                .get(0).intValue();

        System.out.println("Max Value:: " + maxValue);

    }
}

/*
 *
 * Print the maximum number from the given string String abc = "a12x56789w23456";
 * OP :: 56789
 *
Quantifier Description
    *       Matches zero or more occurrences.
    +       Matches one or more occurrences.
    ?       Matches zero or one occurrence.
 * */

