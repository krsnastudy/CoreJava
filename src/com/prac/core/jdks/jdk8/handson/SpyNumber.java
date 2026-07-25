package com.prac.core.jdks.jdk8.handson;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpyNumber {
    public static void main(String[] args) {

        String spyNumbers = Stream.iterate(1, i -> i + 1)
                .limit(10000)
                .filter(SpyNumber::isSpyNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(spyNumbers);
    }

    public static boolean isSpyNumber(int number) {
        String digits = String.valueOf(number);

        int spySum = digits.chars()
                .map(Character::getNumericValue)
                .sum();

        int spyMul = digits.chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);

        return spySum == spyMul;

    }
}
