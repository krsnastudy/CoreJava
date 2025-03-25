package com.prac.core.jdks.jdk8.string;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class StringToCharArray {

	public static void main(String[] args) {

		String str = "This is demo for String to Char Array";
		char[] cArray = str.toCharArray();
		for (char techioChar : cArray) {
			System.out.println(techioChar);
		}

		System.out.println();
		str.chars().mapToObj(x -> (char) x).forEach(System.out::print);

		System.out.println("\nStringTokenizer JDK8");
		StringTokenizer tokenizer = new StringTokenizer(str, " ");
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextToken());
		}

		System.out.println("\nStringTokenizer Stream");
		Collections.list(new StringTokenizer(str, " "))
					.stream().map(x -> (String) x)
					.collect(Collectors.toList())
				    .forEach(System.out::println);
		;
	}

}
