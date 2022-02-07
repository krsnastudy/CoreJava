package com.prac.core.problem.object;

public class ObjectTest {

	public static void main(String[] args) {
		method(null);
		method((Integer)null);
	}

	public static void method(Object obj) {
		System.out.println("Object");
	}

	public static void method(String str) {
		System.out.println("String");
	}
	
	public static void method1(Integer oInteger) {
		System.out.println("Integer");
	}
}
