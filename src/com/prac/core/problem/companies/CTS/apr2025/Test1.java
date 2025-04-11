package com.prac.core.problem.companies.CTS.apr2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        /** Count of characters in a string using Java 8 and pre-Java 8 **/

        String str = "radhakrishna"; // Input string

        // Java 8 style: Count occurrences of each character using streams
        Map<Character, Long> collect = str.chars()  // Convert string to IntStream of characters
                .mapToObj(m -> (char) m)             // Cast int to char and box into Character
                .collect(Collectors.groupingBy(      // Group by character
                        Function.identity(),         // Key = character itself
                        Collectors.counting()));     // Value = count of occurrences

        System.out.println("JDK8 : " + collect);     // Output the character counts

        // Pre-Java 8 style: Count characters using a loop and merge
        Map<Character, Integer> map = new HashMap<>();
        char[] cArray = str.toCharArray();           // Convert string to character array
        for (int i = 0; i < str.length(); i++) {
            map.merge(cArray[i], 1, Integer::sum);   // Increment character count in the map
        }
        System.out.println("JDK5 : " + map);         // Output the character counts

        /** Print non-repeated numbers from a list **/
        // Input list with duplicates
        List<Integer> list = Arrays.asList(1, 1, 4, 5, 6, 5, 3, 2, 7, 9, 5);
        System.out.println("\nList: " + list);       // Print the input list

        // Count occurrences of each number in the list
        System.out.println("Count: " +
                list.stream()
                        .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting())));

        // Find and collect numbers that appear only once
        List<Integer> collect1 = list.stream()
                .collect(Collectors.groupingBy(       // Group elements by value
                        Function.identity(),          // Use number itself as key
                        Collectors.counting()))       // Count occurrences
                .entrySet().stream()                  // Convert to Stream of Map.Entry
                .filter(f -> f.getValue() == 1)       // Keep only entries with count = 1
                .map(m -> m.getKey())                 // Extract keys (unique numbers)
                .collect(Collectors.toList());        // Collect as list
        System.out.println("non repeated numbers: " + collect1); // Print non-repeating numbers
    }

}


/***
 *  Query 7th Highest salary
 *
 * SELECT * FROM (
 *            SELECT
 *                 emp_name, emp_salary,
 *                 DENSE_RANK() OVER (ORDER BY emp_salary DESC) AS rank
 *            FROM employee
 * ) AS subquery WHERE rank = 7;
 *
 * */