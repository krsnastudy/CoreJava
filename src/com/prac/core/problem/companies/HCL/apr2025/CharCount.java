package com.prac.core.problem.companies.HCL.apr2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        String str = "radhakrishna";

        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        Map<Character, Long> collect1 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);

        Map<Character, Integer> collect2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, LinkedHashMap::new));

        System.out.println("Sort By Key   :: "+collect2);

        LinkedHashMap<Character, Integer> collect3 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));

        System.out.println("Sort By Value :: "+collect3);
    }
}
