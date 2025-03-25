package com.prac.core.jdks.jdk8.handson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class StreamsPractice {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Consumer<String> print = x->System.out.format("%s ", x);

		// find out all the even numbers exist in the list using Stream functions
		myList.stream().filter(x -> (x % 2 == 0)).forEach(x->System.out.format("%s ", x));

		System.out.println();
		// find out all the numbers starting with 1 using Stream functions
		myList.stream().map(s -> s + "").filter(x -> x.startsWith("1")).forEach(print);

		System.out.println();
		// find duplicate elements in a given integers list in java using Stream functions
		Set<Integer> set = new HashSet<>();
		myList.stream().filter(s -> !set.add(s)).forEach(System.out::println);
//		System.out.println(set);
		
		System.out.println();
		//find the maximum value element present in it using Stream functions
		int max = myList.stream().max(Integer::compare).get();
		System.out.println("max: "+max);
	}//psvm

}//StreamsPractice
