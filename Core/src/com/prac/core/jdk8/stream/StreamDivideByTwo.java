package com.prac.core.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDivideByTwo {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<>();
		List<Integer> rList = new ArrayList<>();

		aList.add(4);
		aList.add(12);
		aList.add(13);
		aList.add(16);
		aList.add(19);

		rList = aList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

		// rList.forEach(System.out::print);
		rList.forEach(i -> System.out.print(i + " "));
	}
}
