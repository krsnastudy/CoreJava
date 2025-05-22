package com.prac.core.jdks.jdk8.string;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintCharConsecutiveCount {
    public static void main(String[] args) {
        String input = "aabbbbeeeeffggg";
        System.out.println("Given  :: "+input);

        String collect = input.chars()
                .mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .map(m -> (char) m.getKey() + String.valueOf(m.getValue()))
                .collect(Collectors.joining());

        System.out.println("Output :: "+collect);
    }
}
