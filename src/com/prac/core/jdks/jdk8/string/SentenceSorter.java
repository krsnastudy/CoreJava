package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SentenceSorter {

    public static void main(String[] args) {
        String input1 = "is1 Thi0s T3est 2a";
        String input2 = "t2o j3oin 4WonderBiz I0 Technolog5ies wan1t";

        System.out.println("Input 1: " + input1 + "\nOutput 1: " + sortSentence(input1));
        System.out.println();
        System.out.println("Input 2: " + input2 + "\nOutput 2: " + sortSentence(input2));
    }

    public static String sortSentence(String input) {
        // Defensive null / empty check
        if (input == null || input.trim().isEmpty()) {
            return input;
        }

        return Arrays.stream(input.split("\\s+"))   // Split sentence into words
                // Sort words based on the digit inside each word
                .sorted(Comparator.comparingInt(SentenceSorter::extractPosition))
                // Remove digits from each word
                .map(word -> word.replaceAll("\\d", ""))
                // Join words back into a sentence
                .collect(Collectors.joining(" "));
    }

    /**
     * Extracts the numeric position from a word.
     * Example: "Thi0s" → 0, "is1" → 1
     */
    private static int extractPosition(String word) {
        return word.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .findFirst()
                .orElse(Integer.MAX_VALUE); // Safe fallback
    }
}

/**
 * Write a java stream API program to sort a sentence where each word contains a number indicating its position. Return the correctly ordered sentence.
 * Example 1:
 * Input : is1 Thi0s T3est 2a
 * Output: This is a Test
 *
 * Example 2:
 * Input : t2o j3oin 4WonderBiz I0 Technolog5ies wan1t
 * Output: I want to join WonderBiz Technologies
 * **/