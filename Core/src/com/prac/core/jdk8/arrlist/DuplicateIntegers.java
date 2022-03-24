package com.prac.core.jdk8.arrlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateIntegers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		
		findDupByFilter(list);
		findDupByGroupBy(list);
		findDupByFrequency(list);
	}
	
	public static void findDupByFilter(List<Integer> list) {
		Set<Integer> items = new HashSet<>();
		System.out.print("findDupByFilter   : ");
		list.stream().filter(n -> !items.add(n))
			.collect(Collectors.toSet())
			.forEach(i->System.out.print(i+" "));

		System.out.println();
	}

	public static void findDupByGroupBy(List<Integer> list) {
		System.out.print("findDupByGroupBy  : ");
		list.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
			.filter(i->i.getValue()>1)
			.forEach(j->System.out.print(j.getKey()+" "));
		
		System.out.println();
	}
	
	public static void findDupByFrequency(List<Integer> list) {
		System.out.print("findDupByFrequency: ");
		
		list.stream()
			.filter(i->Collections.frequency(list, i)>1)
			.distinct()
			.forEach(i->System.out.print(i+" "))
			;
		
		System.out.println();
	}
}
