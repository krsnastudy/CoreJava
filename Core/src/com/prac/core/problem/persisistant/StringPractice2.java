package com.prac.core.problem.persisistant;

public class StringPractice2 {

	public static void main(String[] args) {
		System.out.println("A" + "B" + "C" + 1 + 2 + 3);
		System.out.println(1 + 2 + 3 + "A" + "B" + "C");

		String str = "MADAM";
		for (int i = (str.length() - 1); i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
}