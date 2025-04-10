package com.prac.core.jdks.jdk8.string;

import java.util.stream.IntStream;

public class FirstLastCharUpperCase {
    public static void main(String[] args) {
        String str = "java"; // Input string

        // Use IntStream to iterate over character indices
        String resString = IntStream.range(0, str.length()) // Create a stream of indices from 0 to str.length() - 1
                .mapToObj(i ->
                        // For first and last character, convert to uppercase
                        (i == 0 || i == str.length() - 1)
                                ? Character.toUpperCase(str.charAt(i)) // Convert to uppercase if first or last character
                                : str.charAt(i)                         // Otherwise, keep the character as-is
                )
                // Collect characters into a StringBuilder, then convert to string
                .collect(
                        StringBuilder::new,         // Supplier: creates new StringBuilder
                        StringBuilder::append,      // Accumulator: appends character to builder
                        StringBuilder::append       // Combiner: used when parallel streams merge
                )
                .toString(); // Convert StringBuilder to final string

        System.out.println(resString); // Print the result
    }
}
