package com.prac.core.jdks.jdk5.exception;

public class TestException {

	public static void main(String[] args) {
		TestException t = new TestException();
		System.out.println("someMethod: " + t.someMethod());
		System.out.println("someMethod(int i): " + t.someMethod(5));
	}

	public int someMethod() {
		try {
			// some statement
			return 1 / 0;
		} catch (Exception e) {
			// some statement
			return 9;
		} finally {
			// finally block statements
			return 99;
		}
	}

	public int someMethod(int i) {
		try {
			// some statement
			return 9;
		} catch (Exception e) {
			// some statement
			return 99;
		} finally {
//			System.out.println(1/0);
			// finally block statements
			return 999;
		}
	}
}
