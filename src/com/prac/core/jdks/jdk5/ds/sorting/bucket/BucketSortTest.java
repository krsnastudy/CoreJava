package com.prac.core.jdks.jdk5.ds.sorting.bucket;

import java.util.Arrays;

public class BucketSortTest {

	public static void main(String[] args) {
		int[] array = { 2, 1, 5, 1, 2, 3, 4, 3, 5, 6, 7, 8, 5, 6, 7, 0 };
		int[] sort = new BucketSort().sort(array, 0, 8);

		System.out.println(Arrays.toString(array));
		
		for (int i = 0; i < sort.length; i++) {
			for (int j = 0; j < sort[i]; j++) {
				System.out.print(i+" ");
			}
		}
	}
}