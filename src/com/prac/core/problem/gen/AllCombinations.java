package com.prac.core.problem.gen;

import java.util.*;
import java.util.stream.IntStream;

public class AllCombinations {
    public static void main(String[] args) {
        String input = "madam";
        List<String> combinations = getCombinations(input);
        System.out.println("All Combinations of "+input+" are of size "+combinations.size());
        combinations.forEach(System.out::println);
    }

    public static List<String> getCombinations(String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();

        // Total combinations = 2^n - 1 (excluding empty set)
        IntStream.range(1, 1 << n).forEach(i -> {
            StringBuilder combo = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    combo.append(str.charAt(j));
                }
            }
            result.add(combo.toString());
        });

        return result;
    }
}
