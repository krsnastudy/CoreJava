package com.prac.core.problem.companies.morganstanley;

public class RuntimePolymorphism {

	public static void main(String[] args) {

		RuntimePolymorphism r = new RuntimePolymorphism();

//		r.m1(null); //The method m1(Object) is ambiguous for the type RuntimePolymorphism
		r.m1((String) null); // String
		r.m1((Integer) null); // Integer
		r.m1((Object) null); // Object
		r.m1("a"); // String
		r.m1("1"); // String
		r.m1(1); // Integer
	}

	public void m1(Object obj) {
		System.out.println("Object");
	}

	public void m1(String str) {
		System.out.println("String");
	}

	public void m1(Integer intObj) {
		System.out.println("Integer");
	}
}
