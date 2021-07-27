package com.prac.core.jdk8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11);

		Optional<Object> o = Optional
				.of(list.stream().filter(x -> x % 2 == 0).max((a, b) -> Integer.compare(a, b)).orElse(0));
		System.out.println("Max Even Integer: " + o.get());

		System.out.println(list.stream().filter(x -> x % 2 == 0).max((a, b) -> Integer.compare(a, b)).orElse(0));
	}

}
