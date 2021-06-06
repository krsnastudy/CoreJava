package com.prac.core.jdk5.threads.thread;

public class Example1 {

	synchronized void m1() {
		System.out.println("M1");
	}

	synchronized void m2() {
		System.out.println("M2");
	}

	synchronized void m3() {
		System.out.println("M3");
	}

	void m4() {
		System.out.println("M4");
	}

}
