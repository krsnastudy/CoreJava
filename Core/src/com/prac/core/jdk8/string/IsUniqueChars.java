package com.prac.core.jdk8.string;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueChars {

	public static void main(String[] args) {
		String check = "car";
		System.out.println(check + " is Unique String : " + isUnique("car"));
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
}
