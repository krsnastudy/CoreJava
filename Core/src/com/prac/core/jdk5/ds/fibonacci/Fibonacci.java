package com.prac.core.jdk5.ds.fibonacci;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    public static int getNthFibOne(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    public static int getNthFibTwo(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return getNthFibTwo(n - 1) + getNthFibTwo(n - 2);
        }
    }

    public static void printFibonacci(int limit) {
        System.out.print("Fibonacci Series(" + limit + "): ");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(limit)
                .map(t -> t[0])
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void getFibonacci(int series) {
        System.out.print("Fibonacci Series(" + series + "): ");
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(series)
                .map(n -> n[0])
                .collect(toList());
        fibonacci.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static int getNthFibJdk8(int series) {
        return Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(series)
                .map(t -> t[0])
                .collect(Collectors.toList())
                .get(series - 1)
                ;
    }

    public static void printFibonacciSum(int series) {
        Optional<Integer> i = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(series)
                .map(n -> n[0])
                .reduce((a, b) -> a + b);
        System.out.println("Fibonacci Series(" + series + ") Sum is " + i.get());
    }
}
