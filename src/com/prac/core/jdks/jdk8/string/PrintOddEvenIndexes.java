package com.prac.core.jdks.jdk8.string;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintOddEvenIndexes {
    public static void main(String[] args) {
        String input = "JavaProgramming";
        Predicate<Integer> evenPredicate = i -> i % 2 == 0;
        Predicate<Integer> oddPredicate = i -> i % 2 != 0;

        System.out.println("Even Indexed Characters: " + getCollect(input, evenPredicate));
        System.out.println("Odd Indexed Characters: " + getCollect(input, oddPredicate));

    }

    private static String getCollect(String input, Predicate<Integer> predicate) {
        return IntStream.range(0, input.length())
                .filter(i-> predicate.test(i))
                .mapToObj(input::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
