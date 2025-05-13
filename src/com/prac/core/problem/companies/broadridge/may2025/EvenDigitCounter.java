package com.prac.core.problem.companies.broadridge.may2025;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EvenDigitCounter {
    public static void main(String[] args) {
        int[] arr = {12, 345, 2, 6, 7896, 100, 10};

        for (int num : arr) {
            int digitCount = countDigits(num);
            if (digitCount % 2 == 0) {
                System.out.println(num + " has even number of digits");
            }
        }

        String collect = Arrays.stream(arr)
                .mapToObj(m -> String.valueOf(m))
                .filter(f -> f.length() % 2 == 0)
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    // Manual method to count digits
    static int countDigits(int num) {
        int count = 0;

        if (num == 0) return 1;  // Edge case

        if (num < 0) num = -num; // Handle negative numbers

        while (num > 0) {
            count++;
            num = num / 10;
        }

        return count;
    }
}
