package com.prac.core.jdk5.string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringArrayExample1 {

	public static void main(String[] args) {

		String[] alphabet = new String[] { "Credit", "Debit", "Loss" };

		// Convert String Array to List
		List<String> list = Arrays.asList(alphabet);

		if (list.contains("A")) {
			System.out.println("Hello A");
		}

		System.out.println(stringContainsItemFromList("Debt", alphabet));
		System.out.println(containsWordsPatternMatch("Debt", alphabet));

	}

	public static boolean stringContainsItemFromList(String inputStr, String[] items) {
		return Arrays.stream(items).anyMatch(inputStr::contains);
	}

	public static boolean containsWordsPatternMatch(String inputString, String[] words) {

		StringBuilder regexp = new StringBuilder();
		for (String word : words) {
			regexp.append("(?=.*").append(word).append(")");
		}

		Pattern pattern = Pattern.compile(regexp.toString());

		return pattern.matcher(inputString).find();
	}
}