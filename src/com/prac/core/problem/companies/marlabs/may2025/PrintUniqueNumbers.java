package com.prac.core.problem.companies.marlabs.may2025;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintUniqueNumbers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,18,11,2,3,4,3,2,1,4,5,6,4,2,3,7,6,5,4,8,7,9,8);
        System.out.println("B4 Numbers :: "+numbers);
        System.out.println("A4 Numbers :: "+Arrays.toString(numbers.stream().distinct().sorted().toArray()));
        System.out.println("A4 Numbers :: "+numbers.stream().distinct().sorted().collect(Collectors.toList()));

        /* Print only non-repeated numbers in orders */
        String collect = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(f->f.getValue()==1L)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "))
        ;

        System.out.println("Sort By Map.Entry::getKey : "+collect);

    }
}
