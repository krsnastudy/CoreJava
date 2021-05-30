package com.prac.core.problem.threads;

public class Counter {
	private volatile int counter=0;

	public int getCounter() {
		return counter;
	}
	
	public void increaseCounter() {
		++counter;
	}
}
