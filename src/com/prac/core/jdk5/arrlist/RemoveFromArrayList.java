package com.prac.core.jdk5.arrlist;

import java.util.*;
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
		System.out.println("Before Removal: "+aList);
		aList.removeIf(e -> e.equalsIgnoreCase(str));
		System.out.println("After  Removal: "+aList);

		Collection<String> filteredCollection = aList.stream().filter(e -> !e.equalsIgnoreCase(str))
				.collect(Collectors.toList());
		System.out.println("filteredCollection: "+filteredCollection);
//		filteredCollection.forEach(System.out::println);

		for (int i = 0; i < aList.size(); i++) {
			if (str.equalsIgnoreCase(aList.get(i))) {
				aList.remove(i);
			}
		}
		System.out.println("After Removal [ForLoop]: "+aList.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList()));

		Comparator<String> asc = Comparator.comparing(String::valueOf);
		System.out.println("Sort List ASC :: "+aList.stream().sorted(asc).toList());
		System.out.println("Sort List DSC :: "+aList.stream().sorted(asc.reversed()).toList());

//		aList.forEach(System.out::println);
	}

}
