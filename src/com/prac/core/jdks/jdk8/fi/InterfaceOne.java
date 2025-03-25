package com.prac.core.jdks.jdk8.fi;

@FunctionalInterface
public interface InterfaceOne {

	abstract void Method();

	default void m1() {
		System.out.println("InterfaceOne default m1");
	}

	static void m2() {
		System.out.println("InterfaceOne Static m2");
	}

}
