package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

    public static void main(String[] args) {
        String str = "Java 8 functional programming";
        System.out.println("Given: " + str);

        // Step 1: Convert to lowercase and remove spaces
        str = str.toLowerCase().replace(" ", "");
        System.out.println("After: " + str);

        // Step 2: Count character occurrences using LinkedHashMap to maintain order
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {
            // Merge: adds 1 to existing count or inserts with value 1 if not present
            map.merge(c, 1, Integer::sum);
        }

        // Step 3: Find the first non-repeated character from the map
        Character nChar = map.entrySet().stream()
                .filter(i -> i.getValue() == 1) // Filter entries with count 1
                .findFirst()                    // Get the first such entry
                .get()                          // Get Optional value
                .getKey();                      // Extract character key

        System.out.println("First Non-Repeated Char (Map): " + nChar);

        // Step 4: Alternative using Java 8 Stream + Collectors
        Character result = str.chars() // Create IntStream from string characters
                .mapToObj(c -> (char) Character.toLowerCase(c)) // Convert int to lowercase char
                .collect(Collectors.groupingBy(
                        Function.identity(),                  // Group by character
                        LinkedHashMap::new,                   // Preserve insertion order
                        Collectors.counting()                 // Count frequency
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)       // Filter entries with count = 1
                .map(Map.Entry::getKey)                        // Get the character
                .findFirst().get();                            // Extract the first non-repeated

        System.out.println("First Non-Repeated Char (Stream): " + result);

        // Step 5: Third approach using only String methods and Stream
        String tempStr = "lohitaaksha";
        System.out.println("First Non-Repeated Char Using Filter: " +
                Arrays.stream(tempStr.split(""))              // Stream of characters as strings
                        .filter(ch -> tempStr.indexOf(ch) == tempStr.lastIndexOf(ch)) // First = Last index → unique
                        .findFirst()                           // Get first non-repeated
                        .orElse("")                            // Fallback if not found
        );
    }
}
