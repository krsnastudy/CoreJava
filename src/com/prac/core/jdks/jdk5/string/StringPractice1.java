package com.prac.core.jdks.jdk5.string;

public class StringPractice1 {

	public static void main(String[] args) {
		bar();

		String str = "HelloWorld";
		System.out.println(str.substring(5));
	}

	public static int foo(int a, String s) {
		s = "Yellow";
		a = a + 2;
		return a;
	}

	public static void bar() {
		int a = 3;
		String s = "Blue";
		a = foo(a, s);
		System.out.println("a=" + a + " s=" + s);
	}
}
