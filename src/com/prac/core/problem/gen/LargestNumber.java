package com.prac.core.problem.gen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    /**
     * Constructs the largest number possible from a list of integers.
     * Example: [54, 546, 548, 60] → "6054854654"
     *
     * @param nums List of integers
     * @return The largest number formed by concatenating elements
     */
    public static String findLargestNumber(List<Integer> nums) {

        // Sort the list using a custom comparator:
        // For two numbers a and b, compare (b+a) vs (a+b) as strings
        // This ensures the combination producing a larger string goes first
        Collections.sort(nums, (a, b) ->
                (String.valueOf(b) + a).compareTo(String.valueOf(a) + b)
        );

        // Edge case: if the largest number is "0", return "0" (instead of "000...")
        if (nums.get(0) == 0) {
            return "0";
        }

        // Convert the sorted list to a string by joining each number
        return nums.stream()
                .map(Object::toString)                 // Convert each integer to string
                .collect(Collectors.joining(""));     // Join without any separator
    }

    public static void main(String args[]) {

        // Define a list of integers
        List<Integer> numbers = Arrays.asList(7, 58, 87, 2, 16, 34, 54, 0, 90);
//        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
//                List<Integer> numbers = Arrays.asList(0, 0, 0);

        // Call the function and print the largest number formed
        System.out.println("The largest number is: " + findLargestNumber(numbers));
    }
}
