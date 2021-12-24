package com.prac.core.jdk8.anonymous;

public class AnonymousInnerClass {
	static int x = 4;
	int y = 3;

	public void m2() {
		// Anonymous Inner Class
		InterfaceA a = new InterfaceA() {
			int x = 5;

			@Override
			public void m1() {
				System.out.println("InterfaceA(): " + this.x);
				System.out.println("AnonymousInnerClass y: " + AnonymousInnerClass.this.y);
				System.out.println("AnonymousInnerClass x: " + AnonymousInnerClass.x);
			}
		};

		a.m1();
	}

	public void m3() {
		// Lambda Expression
		InterfaceA a = () -> {
			int y = 5;
			System.out.println("Lambda Expression: " + this.y);
		};

		a.m1();
	}

	public static void main(String[] args) {
		AnonymousInnerClass a = new AnonymousInnerClass();
		a.m2(); // In Anonymous this refers current class variables
		a.m3(); // In Lamda Expression this refers current outer class variables
	}
}
