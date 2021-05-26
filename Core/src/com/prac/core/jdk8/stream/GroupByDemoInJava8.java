package com.prac.core.jdk8.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupByDemoInJava8 {

	public static void main(String[] args) {
		String[] args1 = {"A", "B"};
		
		Set<String> distinctWords = Arrays.asList(args1).stream()
				.collect(Collectors.toSet());
		/*
		List<String> list = people.stream()
				.map(Person::getName)
				.collect(Collectors.toList());		
				*/
	}

}

