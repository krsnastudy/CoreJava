package com.prac.core.problem.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacentDuplicateRemover {

    public static void main(String[] args) {
        String str = "acaabaabax";
        String reduced = removeDuplicates(str);   // recursive step
        String result = groupInPairs(reduced);    // stream step
        System.out.println(result);               // ac ax
    }

    // Recursively removes the first adjacent duplicate pair found,
    // and keeps recursing until the string stabilizes (base case).
    static String removeDuplicates(String str) {
        String reducedOnce = removeFirstAdjacentPair(str);
        if (reducedOnce.equals(str)) {
            return str;   // base case: no adjacent duplicates left
        }
        return removeDuplicates(reducedOnce);  // recursive case
    }

    static String removeFirstAdjacentPair(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return str.substring(0, i) + str.substring(i + 2);
            }
        }
        return str;
    }

    // Uses Java 8 Stream to split string into 2-char chunks
    static String groupInPairs(String str) {
        return IntStream.range(0, (str.length() + 1) / 2)
                .mapToObj(i -> str.substring(i * 2, Math.min(str.length(), i * 2 + 2)))
                .collect(Collectors.joining(" "));
    }
}

/*
    Input: String Str=""acaabaabax""
    Output: ac ax
    Write a recursive program
*/