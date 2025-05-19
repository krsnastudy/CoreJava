package com.prac.core.jdks.jdk8.arrays;

import java.util.Arrays;
import java.util.Random;

public class SortTenMillion {

	private static final int len = 90000000;

	public static void main(String[] args) {
		// create two arrays of integers of size 10 million
		int[] arr1 = new int[len];
		int[] arr2 = new int[len];

		// Assign random values to arr1[] and arr2[]
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			arr1[i] = r.nextInt();
			arr2[i] = arr1[i];
		}

		System.out.println("Both the Arrays Length: "+arr1.length +" <--> "+ arr2.length);

		long start = System.currentTimeMillis();
		// sort `arr1[]` using `Arrays.sort()`
		Arrays.sort(arr1);
		long end = System.currentTimeMillis();
		System.out.println("Arrays.sort() took " + (end - start) + " ms");

		start = System.currentTimeMillis();
		// sort `arr2[]` using `Arrays.parallelSort()`
		Arrays.parallelSort(arr2);
		end = System.currentTimeMillis();
		System.out.println("Arrays.parallelSort() took " + (end - start) + " ms");
	}
}
