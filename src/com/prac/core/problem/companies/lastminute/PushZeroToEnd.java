package com.prac.core.problem.companies.lastminute;

import java.util.Arrays;

public class PushZeroToEnd {

	public static void main(String[] args) {
		
		int[] array1 = {1, 8, 3, 0, 2, 0, 1, 10, 13, 0};
		reorder(array1);
		System.out.println(Arrays.toString(array1));
		
		int[] array2 = {0, 3, 5, 9, 0, 0, 23, 2};
		reorder(array2);
		System.out.println(Arrays.toString(array2));		
	}

	public static void reorder(int[] arr) {
		int k = 0;

		for (int i : arr) {
			if (i != 0) {
				arr[k++] = i;
			}
		}

		while (k < arr.length)
			arr[k++] = 0;
	}
}


/*
Input: A[] = {1, 8, 3, 0, 2, 0, 1, 10, 13, 0}
Output: {1, 8, 3, 2, 1, 10, 13, 0, 0, 0}

Input: A[] = {0, 3, 5, 9, 0, 0, 23, 2}
Output: {3, 5, 9, 23, 2, 0, 0, 0}

*/