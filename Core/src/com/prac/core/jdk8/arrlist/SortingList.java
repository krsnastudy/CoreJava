package com.prac.core.jdk8.arrlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 8, 0));
		List<Integer> list1 = list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
		list1.forEach(System.out::println);
	}

}
