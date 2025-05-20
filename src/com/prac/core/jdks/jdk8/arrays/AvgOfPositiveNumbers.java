package com.prac.core.jdks.jdk8.arrays;

import java.util.Arrays;
import java.util.OptionalDouble;

public class AvgOfPositiveNumbers {
    public static void main(String[] args) {
        int[] arr = {-6, 8, 1, -4, -3, 2};

        OptionalDouble average = Arrays.stream(arr).filter(f -> f > 0).average();
        System.out.println("Average: "+average.getAsDouble());
    }
}
