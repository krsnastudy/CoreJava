package com.prac.core.problem.companies.broadridge.may2025;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1000);
        map.put("B", 2000);
        map.put("C", 3000);
        map.put("D", 4000);
        map.put("E", 5000);
        map.put("F", 6000);
        map.put("G", 7000);
        map.put("H", 8000);
        map.put("I", 9000);


        /* Print sum of salaries */
        Integer sum = map.values().stream()
                .collect(Collectors.summingInt(Integer::valueOf));
        System.out.println("Total Sum: " + sum);

        Integer sum1 = map.values().stream()
                .reduce((a, b) -> a + b)
                .get();
        System.out.println("Total Sum: " + sum1);

        /* Print Max Salary */
        Integer max1 = map.values().stream()
                .max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("max: " + max1);

        Integer max2 = map.values().stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList()).get(0);
        System.out.println("max: " + max2);
    }
}
