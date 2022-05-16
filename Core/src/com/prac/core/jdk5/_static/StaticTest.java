package com.prac.core.jdk5._static;

public class StaticTest {

	public static void main(String[] args) {
		Base obj1 = new Derived();

		// As per overriding rules this should call to class Derive's static
		// overridden method. Since static method can not be overridden, it
		// calls Base's display()
		obj1.display();

		// Here overriding works and Derive's print() is called
		obj1.print();
	}

}

/*

https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/#:~:text=Can%20we%20Override%20static%20methods,the%20answer%20is%20'No'.

*/
