package com.prac.core.jdk8.fi;

@FunctionalInterface
public interface InterfaceTwo extends InterfaceOne{

	default void print() {}
	abstract void Method();
	
	default void m1() {
		System.out.println("InterfaceTwo Default m1");
	}
	
	static void m2() {
		System.out.println("InterfaceTwo static m2");
	}
	
}
