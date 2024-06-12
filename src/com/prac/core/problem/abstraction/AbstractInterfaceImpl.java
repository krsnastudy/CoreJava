package com.prac.core.problem.abstraction;

public class AbstractInterfaceImpl extends AbstractExTwo{

	public static void main(String[] args) {
		AbstractInterfaceImpl obj = new AbstractInterfaceImpl();
	}

	@Override
	public void methodThree() {
		System.out.println("AbstractInterfaceImpl -- methodThree()");
	}

	@Override
	public void methodTwo() {
		System.out.println("AbstractInterfaceImpl -- methodTwo()");		
	}

	@Override
	public void methodOne() {
		System.out.println("AbstractInterfaceImpl -- methodOne()");		
	}

}
