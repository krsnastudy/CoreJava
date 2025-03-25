package com.prac.core.jdks.jdk5.gen.constructor;

public class ClassA {

	ClassA() {
		this(1);
		System.out.println("In ClassA()");
	}

	ClassA(int a) {
		this(1, 2);
		System.out.println("In ClassA(int a)");
	}

	ClassA(int a, int b) {
		this(1f);
		System.out.println("In ClassA(int a, int b)");
	}

	ClassA(float a) {
		this("String");
		System.out.println("In ClassA(float a)");
	}

	ClassA(String a) {
		this(new Integer(1));
		System.out.println("In ClassA(String a)");
	}

	ClassA(Integer a) {
		System.out.println("In ClassA(Integer a)");
	}
}
