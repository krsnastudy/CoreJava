package com.prac.core.jdks.jdk8.interfaces;

public class Java8InterfaceTesting {

	public static void main(String args[]) {

		new InterfaceTest1().m1();
		new InterfaceTest1().m2();

		// default method
		new InterfaceTest1().m3();

		new InterfaceTest2().m1();
		new InterfaceTest2().m2();

		// default method
		new InterfaceTest2().m3();

		InterfaceTest2.m4();
		I1.m4();

		I1.main(new String[0]);

	}

}

interface I1 {
	void m1();

	void m2();

	default void m3() {
		System.out.println("default method in interface");
	}

	static void m4() {
		System.out.println("static method in interface88888");
	}

	public static void main(String args[]) {

		System.out.println("main method");
	}

}

class InterfaceTest1 implements I1 {

	@Override
	public void m1() {
		System.out.println("Override m1() in InterfaceTest1");

	}

	@Override
	public void m2() {
		System.out.println("Override m2() in InterfaceTest1");

	}

	public void m3() {
		System.out.println("default method in InterfaceTest1");

	}

}

class InterfaceTest2 implements I1 {

	@Override
	public void m1() {
		System.out.println("Override m1() in InterfaceTest2");

	}

	@Override
	public void m2() {
		System.out.println("Override m2() in InterfaceTest2");

	}

	public void m3() {
		System.out.println("default method in InterfaceTest2");

	}

	static void m4() {

		System.out.println("static method in interface :InterfaceTest2");
	}

}