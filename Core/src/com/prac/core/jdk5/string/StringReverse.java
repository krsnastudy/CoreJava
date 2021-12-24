package com.prac.core.jdk5.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringReverse {

	public static void main(String[] args) {

		String str = "INDIA";
		System.out.println("Given String: " + str + "\n");

		System.out.print("String Reverse by String.charAt(index)  : ");
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}

		System.out.print("\n           String Reverse by While Loop : ");
		int l = str.length();
		while (l > 0) {
			System.out.print(str.charAt(l - 1));
			l--;
		}

		System.out.println();
		System.out.print("String Reverse by String.toCharArray()  : ");
		char[] c = str.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			System.out.print(c[i]);
		}

		System.out.println();
		System.out.print("String Reverse by StringBuffer.reverse(): ");
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());

		System.out.print("            String Reverse by Recursive : ");
		reverseString(str);

		System.out.print("String Reverse by     Java8LambdaStream : ");
		System.out.println(usingJava8LambdaStream(str));

		System.out.print("String Reverse by Another  LambdaStream : ");
		System.out.println(usingJava8LambdaStream(str));

	}

	public static void reverseString(String str) {
		if (str == null || (str.length() <= 1)) {
			System.out.println(str);
		} else {
			System.out.print(str.charAt(str.length() - 1));
			reverseString(str.substring(0, (str.length() - 1)));
		}
	}

	public static String usingJava8LambdaStream(final String string) {
		return IntStream.range(0, string.length())
				        .map(i -> string.charAt(string.length() - i - 1))
				        .collect(StringBuilder::new, (s, c) -> s.append((char) c), StringBuilder::append)
				        .toString();
	}

	public static String usingAnotherJava8LambdaStream(final String string) {
		return Stream.of(string)
				     .map(word -> new StringBuilder(word).reverse())
				     .collect(Collectors.joining(" "));
	}
}