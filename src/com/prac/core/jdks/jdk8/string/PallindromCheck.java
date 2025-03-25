package com.prac.core.jdks.jdk8.string;

import java.util.stream.IntStream;

public class PallindromCheck {

	public static void main(String[] args) {
		String str = "madam";

		System.out.println(str + " Is Pallindrome : " + isPallindrome(str));
		System.out.println(str + " Is Pallindrome : " + isPallindrome_jdk5(str));
	}

	public static boolean isPallindrome(String origString) {

		String checkString = origString;
		boolean isPallindrome = false;

		isPallindrome = IntStream.range(0, checkString.length() / 2)
//				.peek(j->System.out.println(checkString.charAt(j)))
//				.allMatch(i->str.charAt(i)==(str.charAt(str.length()-i-1)))
				.noneMatch(i -> checkString.charAt(i) != checkString.charAt(checkString.length() - i - 1));

		return isPallindrome;
	}

	public static boolean isPallindrome_jdk5(String origString) {
		boolean isPallindrome = false;
		String checkString = "";
		for (int i = origString.length() - 1; i >= 0; i--) {
			checkString = checkString + origString.charAt(i);
		}
		isPallindrome = checkString.equals(origString);

		return isPallindrome;

	}

}
