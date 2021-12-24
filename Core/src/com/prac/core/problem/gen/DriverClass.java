package com.prac.core.problem.gen;

class X {
	static int i = 1111;
	static {

//		System.out.println(--i);

		i = i-- - --i; // L1
		System.out.println("L1: " + i);
	}
	{
		i = i++ + ++i; // L2
		System.out.println("L2: " + i);
	}
}

class Y extends X {
	static {
		i = --i - i--; // L3
		System.out.println("L3: " + i);
	}
	{
		i = ++i + i++; // L4
		System.out.println("L4: " + i);
	}
}

public class DriverClass {
	public static void main(String[] args) {
		Y y = new Y();
		System.out.println("L5: " + y.i); // L5
	}
}