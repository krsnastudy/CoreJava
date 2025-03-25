package com.prac.core.jdks.jdk8.map.hashmap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxRepeatedKey {
    public static void main(String[] args) {

        String[] input = {"Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil"};

        String maxRepeatedKey = Arrays.stream(input)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .peek(System.out::println)
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

        System.out.println("maxRepeatedKey: " + maxRepeatedKey);
    }
}


/**
 * Coforge 20-Mar-2025
 * input={"Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil"}
 * <p>
 * find out max repeated word from list
 * Example output=pen
 */

