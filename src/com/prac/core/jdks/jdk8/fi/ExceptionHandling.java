package com.prac.core.jdks.jdk8.fi;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int key = 0;

//		process(arr, key, (v, k)->System.out.print(v/k));
		process(arr, key,
				handleLambdaError((v, k) -> System.out.println("Division For (" + v + "," + k + ") is " + (v / k))));
	}

	private static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : arr) {
			// System.out.print((i+key)+" ");
			if (i == 3) {
				consumer.accept(i, key + 1);
			} else {
				consumer.accept(i, key);
			}
		}
	}

	private static BiConsumer<Integer, Integer> handleLambdaError(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException e) {
//				e.printStackTrace();
				System.out.println("ArithmeticException Occured for values --> (" + v + "," + k + ")");
			}

		};
	}
}
