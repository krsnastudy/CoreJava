package com.prac.core.jdks.jdk8.staticclass;

public class StaticChild extends StaticParent{

	public static void main(String[] args) {
//		display();

		StaticParent obj1 = new StaticParent();
		obj1.display();  // Output: Parent's static display method

		StaticChild obj2 = new StaticChild();
		obj2.display();  // Output: Child's static display method

		StaticParent obj3 = new StaticChild();
		obj3.display();  // Output: Parent's static display method (Method Hiding)
	}

	static void display() {
		System.out.println("Child Class");
	}

}
