package com.prac.core.jdk8.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumOfSeries {
    private static final int series = 149;
    private static Predicate<Integer> evenPredicate = e -> e % 2 == 0;
    private static Predicate<Integer> oddPredicate = e -> e % 2 != 0;

    public static void main(String[] args) {

        sumOfSeries("odd");
    }

    public static void sumOfSeries(String whichPredicate) {
        int value = Stream.iterate(1, n -> n + 1)
                .limit(series)
                .filter(getPredicate(whichPredicate))
                .collect(Collectors.toList())
                .stream().reduce((a, b) -> a + b)
                .get().intValue();

        System.out.println(value);
    }

    // Method to create dynamic predicate based on input
    public static Predicate<Integer> getPredicate(String whichPredicate) {
        Predicate<Integer> predicate = evenPredicate;

        if (whichPredicate.startsWith("even"))
            predicate = evenPredicate;
        else
            predicate = oddPredicate;

        return predicate;
    }

}
