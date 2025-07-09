package com.prac.core.problem.companies.wissen.iv;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharSort {
    public static void main(String[] args) {
        String input="tree"; // output -- eetr

        Comparator<Map.Entry<Character, Long>> comparator = Comparator.comparing(Map.Entry<Character, Long>::getValue).thenComparing(Map.Entry<Character, Long>::getKey).reversed();

        String collect = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new))
                .entrySet().stream()
                .map(m -> String.valueOf(m.getKey()).repeat(m.getValue().intValue()))
                .collect(Collectors.joining());

        System.out.println(collect);
    }
}
