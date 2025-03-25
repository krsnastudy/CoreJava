package com.prac.core.jdks.jdk8.fi;

@FunctionalInterface
public interface InterfaceTwo // extends InterfaceOne
{

	abstract void Method();

	default void print() {
		System.out.println("InterfaceTwo Default print()");
	}

	default void m1() {
		System.out.println("InterfaceTwo Default m1");
	}

	static void m2() {
		System.out.println("InterfaceTwo static m2");
	}

}
