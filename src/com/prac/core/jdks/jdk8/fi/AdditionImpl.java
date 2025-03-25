package com.prac.core.jdks.jdk8.fi;

public class AdditionImpl {

	public static void main(String[] args) {
		AdditionInterface addImpl = (a, b) -> a + b;
		
		addImpl.m2();
		AdditionInterface.m1();
		
		System.out.println(addImpl.addition(5, 4));
	}

}
