package com.prac.core.jdk8.threads.completablefuture;

import java.time.LocalDateTime;

public class TaskThree implements Runnable {

	private int count;

	public TaskThree(int param) {
		this.count = param;
	}

	@Override
	public void run() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Task Three: "+Thread.currentThread().getName()+" -- "+localDateTime);		
		for (int i = 0; i < count; i++) {
			System.out.println("Loop# " + i);
		}
		
		try {
			System.out.println("Task#3 Sleeping For Five Seconds Start");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		System.out.println("Task#3 Sleeping For Five Seconds Over");
	}
}
