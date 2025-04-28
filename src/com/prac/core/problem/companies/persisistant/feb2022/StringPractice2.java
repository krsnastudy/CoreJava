package com.prac.core.problem.companies.persisistant.feb2022;

import java.util.Arrays;

public class StringPractice2 {

	public static void main(String[] args) {
		System.out.println("A" + "B" + "C" + 1 + 2 + 3);
		System.out.println(1 + 2 + 3 + "A" + "B" + "C");

		String str = "MADAM";
		for (int i = (str.length() - 1); i >= 0; i--) {
			System.out.print(str.charAt(i));
		}

		/* Practice */
		System.out.println("\n");
		System.out.println('A' + 'B');
		System.out.println('A' + "B");
		System.out.println('A' + 'B' + "C");
		System.out.println("A" + "B" + 'A' + 10);
		System.out.println(20 + 1.34f + "A" + "B");
		char[] strArr = { 'i', 'n', 'c', 'l', 'u', 'd', 'e', 'h', 'e', 'l', 'p' };
		System.out.println(strArr.toString());
		System.out.println(Arrays.toString(strArr));

	}
}

/*
 * Explanation: If you try to concatenate any different types of data like
 * integer, character, float with string value, the result will be a string. So
 * ‘A’ will be concatenated with “AB” and answer will be “ABA”.
 */