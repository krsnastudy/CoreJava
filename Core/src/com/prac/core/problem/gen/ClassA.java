package com.prac.core.problem.gen;

public class ClassA {

	public void work() {
		System.out.println("ClassA work()");
	}

	public void run() {
		work();
		System.out.println("ClassA run()");
	}
}
