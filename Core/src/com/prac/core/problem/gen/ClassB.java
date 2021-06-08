package com.prac.core.problem.gen;

public class ClassB extends ClassA {

	public static void main(String[] args) {
		ClassB obj = new ClassB();
		obj.run();
	}

	public void work() {
		super.work();
		System.out.println("ClassB work()");
	}
	
	public void run() {
		super.run();
		System.out.println("ClassB run()");
	}
}
