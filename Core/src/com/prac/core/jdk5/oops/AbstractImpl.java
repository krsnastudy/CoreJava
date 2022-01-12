package com.prac.core.jdk5.oops;

public class AbstractImpl extends AbstractOne{

	public static void main(String[] args) {
		AbstractOne one = new AbstractImpl();
		one.method1();
		one.methodTwo();
	}

	@Override
	public void method1() {
		System.out.println("method1");
	}

}
