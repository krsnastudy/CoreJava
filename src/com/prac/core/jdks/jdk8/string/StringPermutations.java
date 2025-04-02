package com.prac.core.jdks.jdk8.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "ABC";
        Set<String> permutations = generatePermutations(input);

        System.out.println("Permutations: " + permutations);
    }

    public static Set<String> generatePermutations(String str) {
        if (str == null || str.length() == 0) {
            return new HashSet<>();
        }

        return IntStream.range(0, str.length()) // Iterate through each character
                .boxed()
                .flatMap(i -> {
                    String remaining = str.substring(0, i) + str.substring(i + 1);
                    return generatePermutations(remaining).stream()
                            .map(s -> str.charAt(i) + s);
                })
                .collect(Collectors.toSet());
    }
}
