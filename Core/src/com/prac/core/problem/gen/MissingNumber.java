package com.prac.core.problem.gen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 6 };
		findMissing(arr);
	}

	public static void findMissing(int[] arr) {

		List<Integer> iList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();

//		IntStream.rangeClosed(min, max)
		IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt())
				.mapToObj(i -> i)
				.forEach(i -> {
//					if (Arrays.stream(arr).boxed().collect(Collectors.toList()).contains(i)) {
					if (iList.contains(i)) {
						System.out.println(i + " is Existing ");
					} else {
						System.out.println(i + " is Missing ");
					}
				});
	}
}
