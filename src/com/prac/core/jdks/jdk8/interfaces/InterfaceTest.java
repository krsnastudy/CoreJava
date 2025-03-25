package com.prac.core.jdks.jdk8.interfaces;

public class InterfaceTest {

	public static void main(String[] args) {
		InterfaceOne iOne = new InterfaceImpl();
		new InterfaceParam().doImplementation(iOne);
	}
}

interface InterfaceOne {
	public void calculate();

	public void display();
}

class InterfaceParam {

	public void doImplementation(InterfaceOne iOne) {
		iOne.calculate();
		iOne.display();
	}
}

class InterfaceImpl implements InterfaceOne {

	@Override
	public void calculate() {
		System.out.println("InterfaceImpl calculate()");

	}

	@Override
	public void display() {
		System.out.println("InterfaceImpl display()");
	}

}
