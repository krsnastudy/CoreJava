package com.prac.core.problem.morganstanley;

public class ClassImpl {

	public static void main(String[] args) {
//		ClassB b = new ClassA(); //Type mismatch: cannot convert from ClassA to ClassB

		ClassA b = new ClassB();
		b.m1(); // ClassB m1()
		b.m2(); // ClassA m2()
//		b.m3(); // The method m3() is undefined for the type ClassA
	}

}

/*
 * 
 * Compile Time Polymorphism
 * 
 */