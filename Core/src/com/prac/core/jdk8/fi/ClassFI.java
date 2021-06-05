package com.prac.core.jdk8.fi;

public class ClassFI implements InterfaceOne, InterfaceTwo{

	public static void main(String[] args) {
		ClassFI oClassFI = new ClassFI();
		oClassFI.Method();
		oClassFI.m1();
		
//		InterfaceOne.m1();
		InterfaceOne.m2();
		
		/*Cannot make a static reference to the 
		 * non-static method m1() from the type InterfaceTwo*/
//		InterfaceTwo.m1();
		InterfaceTwo.m2();
	}

	@Override
	public void Method() {
		System.out.println("In Impl Class");
	}

	@Override
	public void m1() {
		InterfaceTwo.super.m1();
//		InterfaceOne.super.m1();
	}

	@Override
	public void print() {
		
	}
}
