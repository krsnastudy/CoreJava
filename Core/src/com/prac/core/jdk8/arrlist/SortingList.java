package com.prac.core.jdk8.arrlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 8, 0));

		// Reverse Order
		List<Integer> list1 = list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
//		List<Integer> list2 = list.stream().sorted(Collections.reverseOrder()).toList();
		list1.forEach(i -> System.out.print(i + " "));

		System.out.println();
		// Normal Order
		List<Integer> list2 = list.stream().sorted().toList();
		List<Integer> list3 = list.stream().sorted((a, b) -> a - b).collect(Collectors.toList());

		list2.forEach(i -> System.out.print(i + " "));
		System.out.println();
		Collections.sort(list3);
	}

}
