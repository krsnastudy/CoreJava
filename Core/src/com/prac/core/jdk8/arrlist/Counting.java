package com.prac.core.jdk8.arrlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Counting {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("Krishna");
		list1.add("Radha");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("RadhaKrishna");
		list1.add("Radha");
		list1.add("Krishna");

		Map<Object, Long> counters = list1.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(counters);

	}
}
