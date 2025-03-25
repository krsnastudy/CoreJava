package com.prac.core.jdks.jdk8.fi;

@FunctionalInterface
public interface AdditionInterface {
	public abstract int addition(int a, int b);

	public static void m1() {
		System.out.println("Static Method");
	}
	
	public default void m2() {
		System.out.println("default Method");
	}
}
