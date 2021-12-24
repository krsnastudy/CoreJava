package com.prac.core.jdk5.oops;

public class ClassB implements ClassA {

	public static void main(String[] args) {
		ClassA obj = new ClassB();
		obj.method();

		obj = null;

		obj.method();

	}

	@Override
	public void method() {
		System.out.println("B");
	}

}
