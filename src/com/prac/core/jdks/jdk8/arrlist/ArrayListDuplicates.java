package com.prac.core.jdks.jdk8.arrlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayListDuplicates {
	public static void main(String[] args) {

		List<String> org = new ArrayList<>();
		List<String> res = new ArrayList<>();

		org.add("A");
		org.add("B");
		org.add("E");
		org.add("A");
		org.add("B");
		org.add("C");
		org.add("D");
		org.add("E");

		Collections.unmodifiableList(org);

		System.out.print("Original List: " + org);

		res = org.stream().distinct().filter(e -> Collections.frequency(org, e) > 1).collect(Collectors.toList());
		System.out.println("\nList of Duplicate Values: " + res);

		res = org.stream().distinct().filter(e -> Collections.frequency(org, e) == 1).collect(Collectors.toList());
		System.out.println("List with Only occurance Once: " + res);

		res = org.stream().distinct().collect(Collectors.toList());
		System.out.println("List with unique values: " + res);

		List<String> list1 = new ArrayList<>();
		list1.add("M1");
		list1.add("M2");
		list1.add("M2");
		list1.add("M4");
		list1.add("M11");

		boolean flag = list1.stream().anyMatch(n -> n.equals("M1"));
		System.out.println("flag: " + flag);

		List<String> list = Arrays.asList("M1", "M2", "M3", "M4");
		String strMatcher = "M11";
		boolean match = list.stream().anyMatch(strMatcher::contains);
		System.out.println("match: " + match);

		String a = "String";
		String b = "String";
		String c = new String("String");
		System.out.println("(a==b): " + (a == b));
		System.out.println("(a==c): " + (a == c));
		System.out.println("a.equals(c): " + a.equals(c));

		String str = "This is a test string to print duplicate values in it";
		IntStream intStream = str.chars();
		Stream<Character> charsStream = intStream.mapToObj(ch -> (char) ch);
		Map<Character, Long> output = charsStream.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		System.out.println(output);

		List<Integer> aList = new ArrayList<>();
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		aList.add(5);
		aList.add(6);
		aList.add(6);
		aList.add(6);
		aList.add(5);

		int res1 = aList.stream().mapToInt(Integer::intValue).max().orElse(0);
		System.out.println(res1);

		int max = aList.stream().mapToInt(Integer::intValue).max().getAsInt();
		System.out.println(max);
	}
}