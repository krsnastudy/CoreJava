package com.prac.core.jdk5.mem;

class GarbageCollectionTest {

	String objname;
	static String s1 = null;

	public GarbageCollectionTest(String objname) {
		this.objname = objname;
		this.s1 = "Satya";
	}

	static void show() {
		GarbageCollectionTest t1 = new GarbageCollectionTest("Object1");
		display();
	}

	static void display() {
		GarbageCollectionTest t2 = new GarbageCollectionTest("Object2");
		s1 = null;
		s1 = "rk";
	}

	public static void main(String args[]) {
		show();
		System.gc();
	}

	protected void finalize() throws Throwable {
		System.out.println(this.objname + " Successfully Garbage Gollected");
		System.out.println("Successfully Garbage Collected " + s1 + "\n");
	}
}
