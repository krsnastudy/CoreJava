package com.prac.core.jdks.jdk8.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "KRSNA";
        Set<String> permutations = getPermutations(input);
        permutations.forEach(System.out::println);
    }

    public static Set<String> getPermutations(String str) {
        Set<String> result = new HashSet<>();

        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }

        char first = str.charAt(0);
        String remaining = str.substring(1);

        Set<String> words = getPermutations(remaining);

        words.forEach(word -> {
            for (int i = 0; i <= word.length(); i++) {
                result.add(insertCharAt(word, first, i));
            }
        });

        return result;
    }

    private static String insertCharAt(String word, char c, int i) {
        return word.substring(0, i) + c + word.substring(i);
    }
}
