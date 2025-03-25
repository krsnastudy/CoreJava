package com.prac.core.jdks.jdk5.ds.sorting.bucket;

public class BucketSort {
	public int[] sort(int[] array, int min, int max) {
		int range = max - min + 1;
		int[] result = new int[range];
		for (int i : array) {
			result[i]++;
		}
		return result;
	}
}
