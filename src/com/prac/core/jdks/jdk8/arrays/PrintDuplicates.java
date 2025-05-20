package com.prac.core.jdks.jdk8.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintDuplicates {
    public static void main(String[] args) {
        String str = "Venkata radhaKrishna Cheetirala";
        str = str.replaceAll(" ", "").toLowerCase();
        System.out.println("Given String :: " + str);

        LinkedHashMap<Character, Long> countMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("Characters Count       :: " + countMap);

        LinkedHashMap<Character, Long> sortByValue = countMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        System.out.println("Characters sortByValue :: " + sortByValue);

        LinkedHashMap<Character, Long> sortByKey = countMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, latest) -> old, LinkedHashMap::new));
        System.out.println("Characters sortByKey   :: " + sortByKey);

        Comparator<Map.Entry<Character, Long>> comparator = Comparator.comparing(Map.Entry<Character, Long>::getKey).thenComparing(Map.Entry<Character, Long>::getValue);
        LinkedHashMap<Character, Long> sortByKeyValue = countMap.entrySet().stream().sorted(comparator).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        System.out.println("Characters sortByKeyValue   :: " + sortByKeyValue + "\n");

        Set<Character> set = new HashSet<>();
        Set<Character> collect =
                str.chars()
                        .mapToObj(c -> (char) c)
//                   .peek(p->System.out.println("Character: "+p+" ---> SET"+set))
                        .filter(f -> !set.add(f))
                        .collect(Collectors.toSet());

        System.out.println("Duplicate Elements :: " + " --> " + collect);
        System.out.println("Unique    Elements :: " + " --> " + countMap.entrySet().stream().filter(f -> f.getValue() == 1L).map(m -> m.getKey()).collect(Collectors.toSet()));
    }
}