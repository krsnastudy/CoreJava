package com.prac.core.jdk5.arrlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveFromArrayList {

	public static void main(String[] args) {
		List<String> aList = new ArrayList<>();
		String str = "good";

		aList.add("good");
		aList.add("test");
		aList.add("run");
		aList.add("work");
		aList.add("good");
		aList.add("migrate");
		aList.add("behave");
		aList.add("known");
		aList.add("good");
		aList.add("test");
		aList.add("known");
		aList.add("good");

		aList.removeIf(e -> e.equalsIgnoreCase(str));
		System.out.println("After Removal: "+aList);

		Collection<String> filteredCollection = aList.stream().filter(e -> !e.equalsIgnoreCase(str))
				.collect(Collectors.toList());

		filteredCollection.forEach(System.out::println);

		for (int i = 0; i < aList.size(); i++) {
			if (str.equalsIgnoreCase(aList.get(i))) {
				aList.remove(i);
			}
		}

		aList.forEach(System.out::println);
	}

}
