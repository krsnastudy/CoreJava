package com.prac.core.jdks.jdk8.gen.armstrong;

import java.util.Random;
import java.util.stream.IntStream;

public class ArmstrongWithStreams {

    /**
     * Checks whether a given number is an Armstrong number.
     * An Armstrong number is a number that is equal to the sum of its own digits
     * each raised to the power of the number of digits.
     *
     * Example: 9474 = 9^4 + 4^4 + 7^4 + 4^4 = 9474
     *
     * @param number the number to check
     * @return true if number is Armstrong, false otherwise
     */
    public static boolean isArmstrong(int number) {
        int digits = String.valueOf(number).length(); // Number of digits in the number

        int sum = String.valueOf(number)     // Convert number to string
                .chars()                     // Get IntStream of ASCII values of digits
                .map(c -> Character.getNumericValue(c)) // Convert ASCII to actual digit
                .map(d -> (int) Math.pow(d, digits))    // Raise digit to the power of number of digits
                .sum();                      // Sum all powered digits

        return sum == number;                // Compare the sum to original number
    }

    /**
     * Prints all Armstrong numbers in the given range [start, end].
     * Utilizes Java 8 IntStream and method reference for concise logic.
     *
     * @param start starting number of the range
     * @param end   ending number of the range
     */
    public static void printArmstrongInRange(int start, int end) {
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");

        IntStream.rangeClosed(start, end)    // Inclusive range from start to end
                .filter(ArmstrongWithStreams::isArmstrong) // Keep only Armstrong numbers
                .forEach(System.out::println);             // Print each found Armstrong number
    }

    public static void main(String[] args) {
        int checkArmstrong=1634;
        // Test isArmstrong method with a known Armstrong number
        System.out.println("Is "+checkArmstrong+" Armstrong? " + isArmstrong(checkArmstrong));

        // Print all 3- and 4-digit Armstrong numbers
        printArmstrongInRange(new Random().nextInt(9, 999), new Random().nextInt(1000, 9999));
    }
}
