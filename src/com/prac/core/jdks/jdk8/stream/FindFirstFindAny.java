package com.prac.core.jdks.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstFindAny {

	public static void main(String[] args) {

//		List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Optional<Integer> first = list.stream().findFirst();

		if (first.isPresent()) {
			Integer result = first.get();
			System.out.println(result); // 1
		} else {
			System.out.println("no value?");
		}

		Optional<Integer> first2 = list.stream().filter(x -> x > 2).findFirst();

		if (first2.isPresent()) {
			System.out.println(first2.get()); // 3
		} else {
			System.out.println("no value?");
		}

		Optional<Integer> any = list.stream().filter(x -> x > 6).findAny();

		if (any.isPresent()) {
			Integer result = any.get();
			System.out.println(result);
		}
	}
}