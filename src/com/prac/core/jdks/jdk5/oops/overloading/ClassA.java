package com.prac.core.jdks.jdk5.oops.overloading;

public class ClassA {

	public static void main(String[] args) {
		int res = add((float) 1, 2);
		System.out.println(res);
	}

	public static int add(float a, int b) {
		return (int) (a + b);
	}

	public static int add(int a, float b) {
		return (int) (a + b);
	}
}