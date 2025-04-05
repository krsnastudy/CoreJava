package com.prac.core.jdks.jdk8.string;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NthRepeatedChar {
    public static void main(String[] args) {
        String str = "In Java 8, we can use Streams, Collectors, and String manipulations to reverse the words in a sentence efficiently";
        str = str.toLowerCase(Locale.ROOT).replaceAll(" ", "");
        System.out.println(str);

        LinkedHashMap<Character, Long> charMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("charMap: " + charMap);

/**  Using Java 8 Streams and LinkedHashMap **/
        char firstRepeat = str.chars()
                .mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() > 1)
//                .peek(p-> System.out.println(p))
                .findFirst().get().getKey();

        System.out.println("First Repeating Character: " + firstRepeat);

/**  Using Java 8 Streams and Set **/
        Optional<Character> firstRepeating = str.chars()  // Convert to IntStream
                .mapToObj(c -> (char) c)  // Convert int to char
                .filter(new LinkedHashSet<>()::add)  // Add to Set, returns false if duplicate
                .findFirst();  // Get first repeating character

        System.out.println("First Repeating Character: " + firstRepeating.orElse(null));

        System.out.println();
        System.out.println("First Highest Repeating Character: " + getRepeatedChar(charMap, 1));
        System.out.println("Second Highest Repeating Character: " + getRepeatedChar(charMap, 2));
        System.out.println("Third Highest Repeating Character: " + getRepeatedChar(charMap, 3));
        System.out.println("Fourth Highest Repeating Character: " + getRepeatedChar(charMap, 4));
        System.out.println("Fifth Highest Repeating Character: " + getRepeatedChar(charMap, 5));

    }

    public static char getRepeatedChar(LinkedHashMap<Character, Long> charMap, int which) {

        return charMap.entrySet().stream()
                .filter(f -> f.getValue() > 1)
                .skip(which - 1).findFirst().get().getKey();
    }

}
