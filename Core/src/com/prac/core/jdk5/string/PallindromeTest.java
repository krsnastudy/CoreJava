package com.prac.core.jdk5.string;

import java.util.HashSet;
import java.util.Set;

public class PallindromeTest {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();
		set.add("Hare Krishna");
		set.add("Hare Rama");
		set.add("Rama Rama");
		set.add("Hare Hare");
		System.out.println(set);

		int n = 45354;
		String s = "MADAM";
		System.out.println(n + " Is " + (nPallindrome(n) ? "Pallindrome" : "Not Pallindrome"));
		System.out.println(s + " Is " + (sPallindrome(s) ? "Pallindrome" : "Not Pallindrome"));
	}

	public static boolean nPallindrome(int n) {
		boolean isPallindrome = false;
		int rem, sum = 0, temp = n;

		while (n > 0) {
			rem = n % 10;
			sum = rem + (sum * 10);
			n = n / 10;
		}

		isPallindrome = (temp == sum) ? true : false;

		return isPallindrome;
	}

	public static boolean sPallindrome(String str) {
		String reverse = "";

		for (int i = (str.length() - 1); i >= 0; i--) {
			reverse = reverse + str.charAt(i);
//			System.out.println(str.charAt(i)+" -- "+reverse);
		}

		return reverse.equals(str);

	}

}
