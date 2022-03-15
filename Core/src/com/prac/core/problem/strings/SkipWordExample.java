package com.prac.core.problem.strings;

import java.util.Arrays;
import java.util.List;

public class SkipWordExample {

	public static void main(String[] args) {
		
		List<String> lines = Arrays.asList("demo", "test", "IBM", "test");
		
		lines.stream().filter(p -> !p.equalsIgnoreCase("test")).forEach(i -> System.out.println(i));
	}
}

// Word to exclude: test