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

		System.out.println();
		int[] array3 = {9, 0, 5, 1, 8, 3, 0, 2, 0, 1, 10, 13, 0};
		reorderNew(array3);
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

	public static void reorderNew(int[] arr){
		int[] rArr = new int[arr.length];
		int i=0;
		System.out.println("Given :: "+Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println("Sort  :: "+Arrays.toString(arr));

		for(int e : arr){
			if(e>0){
				rArr[i]=e;
				i++;
			}
		}
		System.out.println("Moved :: "+Arrays.toString(rArr));
	}

}


/*
Input: A[] = {1, 8, 3, 0, 2, 0, 1, 10, 13, 0}
Output: {1, 8, 3, 2, 1, 10, 13, 0, 0, 0}

Input: A[] = {0, 3, 5, 9, 0, 0, 23, 2}
Output: {3, 5, 9, 23, 2, 0, 0, 0}

*/