package com.prac.core.jdk8.stream;

import java.util.Arrays;

import java.util.Arrays;

public class SumOfPairs {

	/**
	 * Finds and prints all pairs in the sorted array whose sum equals the given target sum.
	 * @param arr The input array (must be sorted before calling this method).
	 * @param sum The target sum to find pairs for.
	 */
	public void findPairWithSum(int arr[], int sum) {
		if (arr == null || arr.length < 2) {
			System.out.println("Invalid input: Array must have at least two elements.");
			return;
		}

		int low = 0, high = arr.length - 1;

		while (low < high) {
			int currentSum = arr[low] + arr[high]; // Avoid redundant calculations

			if (currentSum == sum) {
				System.out.println("Pair found: (" + arr[low] + ", " + arr[high] + ")");
				low++; // Move both pointers to avoid duplicate pairs
				high--;
			} else if (currentSum > sum) {
				high--; // Decrease high pointer to reduce sum
			} else {
				low++; // Increase low pointer to increase sum
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {2, 3, 4, -2, 6, 8, 9, 11};
		int targetSum = 6;

		System.out.println("Target Sum: " + targetSum);

		// Sort the array before passing to findPairWithSum
		Arrays.sort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));

		System.out.println();
		SumOfPairs sp = new SumOfPairs();
		sp.findPairWithSum(arr, targetSum);
	}
}
