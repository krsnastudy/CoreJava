package com.prac.core.jdks.jdk8.string;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueChars {

	public static void main(String[] args) {
		String check = "car";
		System.out.println(check + " is Unique String : " + isUnique("car"));
		System.out.println(check + " is Unique String : " + checkForUnique("car"));
		
	}

	public static boolean isUnique(String input) {

		Set<Character> hSet = new HashSet<>();
		char[] cArray = input.toCharArray();

		for (Character c : cArray) {
			if (!hSet.add(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkForUnique(String str) {
		boolean containsUnique = false;

		for (char c : str.toCharArray()) {
			if (str.indexOf(c) == str.lastIndexOf(c)) {
				containsUnique = true;
			} else {
				containsUnique = false;
			}
		}

		return containsUnique;
	}
}

/*
 * https://www.java67.com/2017/08/how-to-determine-if-string-has-all-unique-
 * characters-in-java.html
 */
