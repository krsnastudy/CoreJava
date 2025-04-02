package com.prac.core.jdks.jdk8.string;

import java.util.function.Predicate;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        String input = "Java Programming";
        String vowels = "aeiou";
        String str = input.toLowerCase().replaceAll(" ", "");

        Predicate<Character> vowelFilter = f -> vowels.indexOf(f) != -1;
        Predicate<Character> consonantFilter = f -> vowels.indexOf(f) == -1;

        System.out.println("Vowel Count: " + getCount(str, vowelFilter));
        System.out.println("Consonants Count: " + getCount(str, consonantFilter));

    }

    private static long getCount(String str, Predicate<Character> characterPredicate) {
        return str.chars().mapToObj(m -> (char) m)
                .filter(c -> Character.isLetter(c))
                .filter(characterPredicate)
                .count();
    }
}
