package com.prac.core.problem.equal;

public class TestA {

	public static void main(String[] args) {
		A a1 = new A(5);
		A a2 = new A(5);
		A a3 = a1;

		System.out.println("(a1==a2): " + (a1 == a2));
		System.out.println("(a1==a3): " + (a1 == a3));
	}

}
