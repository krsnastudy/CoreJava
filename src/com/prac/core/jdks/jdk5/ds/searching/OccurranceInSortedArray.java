package com.prac.core.jdks.jdk5.ds.searching;

import java.util.Arrays;

public class OccurranceInSortedArray {

	public static void main(String[] args) {
//		int[] input = {10,20,30,30,30,40,50};
		int input[] = { 1, 2, 3, 6, 6, 6, 8, 9, 9 };

		Arrays.sort(input);

		int key = 6;
		int[] arr = findFirstLastOccurance(key, input);
		int first = 0, last = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				first = i;
				break;
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				last = i;
				break;
			}
		}

		System.out.println("First Index: " + first + " & Last Index: " + last);
	}

	static int[] findFirstLastOccurance(int key, int[] input) {
		int[] arr = new int[input.length];
		for (int i = 0, j = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
			if (input[i] == key) {
				arr[i] = i;
			} else {
				arr[i] = 0;
			}
		}

		System.out.println("\narr: " + Arrays.toString(arr));
		return arr;
	}

}