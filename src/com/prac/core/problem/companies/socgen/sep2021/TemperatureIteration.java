package com.prac.core.problem.companies.socgen.sep2021;

import java.util.*;

public class TemperatureIteration {
    public static void main(String[] args) {
        int[] arr = {23, 24, 25, 21, 19, 26, 23};
        int[] result = getGreaterTempCounts(arr);

        // Print the result array
        System.out.println(Arrays.toString(result));
    }

    // Method to calculate iteration count for each temperature
    public static int[] getGreaterTempCounts(int[] arr) {
        int[] result = new int[arr.length];

        // Loop through each temperature
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            // Compare with the subsequent elements
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }

            // Store the result in the output array
            result[i] = count;
        }

        return result;
    }
}
