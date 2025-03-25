package com.prac.core.jdks.jdk8.arrlist;

import java.util.Arrays;
import java.util.List;

public class NumberStartsWith {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 12, 59, 34);
		
		list.stream().distinct().sorted()
			.map(s->s+"")
			.filter(i->i.startsWith("1"))
			.forEach(System.out::println);
	}

}
