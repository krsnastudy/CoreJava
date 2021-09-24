package com.prac.core.jdk8.threads.completablefuture;

import java.time.LocalDateTime;

public class TaskTwo implements Runnable {

	private int count;

	public TaskTwo(int param) {
		this.count = param;
	}

	@Override
	public void run() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Task Two: " + Thread.currentThread().getName() + " -- " + localDateTime);
		for (int i = 0; i < count; i++) {
			System.out.println("Loop# " + i);
		}
		
		try {
			System.out.println("Task#2 Sleeping For Three Seconds Start");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		System.out.println("Task#2 Sleeping For Three Seconds Over");
	}
}
