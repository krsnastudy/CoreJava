package com.prac.core.jdks.jdk8.gen.factorial;

import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        long factorial = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    public static long factorial(int n) {
        return (n < 2) ? 1 :
                IntStream.rangeClosed(2, n)
                        .reduce(1, (a, b) -> a * b);
    }
}
