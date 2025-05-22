package com.prac.core.jdks.jdk8.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintCount {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 1, 4, 5, 1, 2};


        String collect = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(m -> m.getKey() + " occurs " + m.getValue() + " times\n")
                .collect(Collectors.joining());

        System.out.println(collect);
    }
}
