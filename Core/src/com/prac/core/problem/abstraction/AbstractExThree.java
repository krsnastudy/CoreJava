package com.prac.core.problem.abstraction;

public abstract class AbstractExThree {

	int local;
	
	private AbstractExThree() {
		System.out.println("AbstractExThree Constructor");
	}

	public AbstractExThree(int a) {
		this.local=a;
	}
	
	public abstract void methodFour();
}
