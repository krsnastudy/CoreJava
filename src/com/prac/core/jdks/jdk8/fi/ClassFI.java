package com.prac.core.jdks.jdk8.fi;

public class ClassFI implements InterfaceOne, InterfaceTwo {

	public static void main(String[] args) {
		ClassFI oClassFI = new ClassFI();
//		oClassFI.Method();
		oClassFI.m1();
		// oClassFI.print();

//		InterfaceOne.m1();
		InterfaceOne.m2(); // Static Method

		/*
		 * Cannot make a static reference to the non-static method m1() from the type
		 * InterfaceTwo
		 */
//		InterfaceTwo.m1();
		InterfaceTwo.m2(); // Static Method
	}

	@Override
	public void Method() {
		System.out.println("In Impl Class");
	}

	@Override
	public void m1() {
		System.out.println("In Class Impl override m1()");
		InterfaceOne.super.m1();
		InterfaceTwo.super.m1();
		System.out.println();
	}

	@Override
	public void print() {
		System.out.println("Impl Class Default print");
	}
}
