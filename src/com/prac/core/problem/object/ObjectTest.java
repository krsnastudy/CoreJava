package com.prac.core.problem.object;

public class ObjectTest {

	public static void main(String[] args) {
//		method(null); //The method method(Object) is ambiguous for the type ObjectTest
		method((String)null);
		method((Integer)null);
	}

	public static void method(Object obj) {
		System.out.println("Object");
	}

	public static void method(String str) {
		System.out.println("String");
	}
	
	public static void method(Integer oInteger) {
		System.out.println("Integer");
	}
}
