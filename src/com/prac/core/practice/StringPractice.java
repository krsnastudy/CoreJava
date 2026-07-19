package com.prac.core.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPractice {

    public static void main(String[] args) {

        System.out.println("Print Non-Repeated First Character");
        String str = "zzzzzbbbccccddehhhhiii";

        str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(f -> f.getValue() == 1L)
                .findFirst().map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

}
