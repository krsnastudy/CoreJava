package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String str1 = "peek";
		String str2 = "keep";

		System.out.println("IsAnagram(" + str1 + ", " + str2 + "): " + (isAnagramSort(str1, str2)));
	}

	public static boolean isAnagramSort(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] a1 = string1.toCharArray();
		char[] a2 = string2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);

//		return String.valueOf(a1).equals(String.valueOf(a2));
		return Arrays.equals(a1, a2);
	}
}
