package com.prac.core.jdks.jdk5.arrlist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FinalArrayList {

	public static void main(String[] args) {

		final List<Integer> list1 = 
				Stream.iterate(0, n -> n + 1)
				.filter(i -> i % 2 == 0).limit(10)
				.collect(Collectors.toList());
		System.out.println(list1);
		list1.add(20);
		System.out.println(list1);
	}
}