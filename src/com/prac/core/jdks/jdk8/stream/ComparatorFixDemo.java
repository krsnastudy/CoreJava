package com.prac.core.jdks.jdk8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparatorFixDemo {

    public static void main(String[] args) {

        String[] sentences = {
                "Java is great and Java is powerful",
                "Spring Boot makes Java development easy"
        };

        // ---------- Common aggregation step (shared by all 4 options) ----------
        Map<String, Long> wordCounts = Arrays.stream(sentences)
                .flatMap(s -> Arrays.stream(s.toLowerCase().split(" ")))
                .map(word -> word.replaceAll("[^a-z0-9]", ""))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("=== Option A: Explicit type witness ===");
        Map<String, Long> resultA = wordCounts.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>, String>comparing(Map.Entry::getKey)
                        .thenComparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        resultA.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n=== Option B: Lambdas instead of method references ===");
        Map<String, Long> resultB = wordCounts.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>, String>comparing(e -> e.getKey())
                        .thenComparing(e -> e.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        resultB.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n=== Option C: Typed variable anchors inference ===");
        Comparator<Map.Entry<String, Long>> byKey = Comparator.comparing(Map.Entry::getKey);
        Map<String, Long> resultC = wordCounts.entrySet().stream()
                .sorted(byKey.thenComparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        resultC.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n=== Option D: Map.Entry's built-in comparators (idiomatic) ===");
        Map<String, Long> resultD = wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey().thenComparing(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
        resultD.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}