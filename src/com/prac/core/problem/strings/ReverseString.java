package com.prac.core.problem.strings;

import java.util.stream.Stream;

public class ReverseString {
	public static void main(String[] args) {
		String str = "Java 8 functional programming";
		String revStr1 = Stream.of(str.split("")).reduce("", (r,c)->c+r);
		System.out.println("Reverse Type1 : "+revStr1);
	}
}