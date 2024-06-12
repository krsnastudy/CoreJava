package com.prac.core.problem.gen;

public class TestVariables {

	// Declaring and initializing variables
	int y = 2;
	int x = y + 2;

	// main driver method
	public static void main(String[] args) {
		// Creating an object of class inside main() method
		TestVariables m = new TestVariables();

		// Printing the value of x and y
		// using above object created
		System.out.println("x = " + m.x + ", y = " + m.y);
	}
}