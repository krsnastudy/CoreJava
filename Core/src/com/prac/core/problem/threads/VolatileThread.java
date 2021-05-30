package com.prac.core.problem.threads;

public class VolatileThread extends Thread{

	private final Counter counter;
	
	public VolatileThread(Counter counter) {
		this.counter=counter;
	}
	
	@Override
	public void run() {
		int oldValue = counter.getCounter();
		System.out.println("Thread: "+Thread.currentThread().getId()+" - OldValue: "+oldValue);
		counter.increaseCounter();
		int newValue = counter.getCounter();
		System.out.println("Thread: "+Thread.currentThread().getId()+" - NewValue: "+newValue);
	}
	
}
