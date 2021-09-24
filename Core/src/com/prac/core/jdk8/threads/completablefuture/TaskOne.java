package com.prac.core.jdk8.threads.completablefuture;

import java.time.LocalDateTime;

public class TaskOne implements Runnable {
	private int count;

	public TaskOne(int param) {
		this.count = param;
	}

	@Override
	public void run() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Task One: " + Thread.currentThread().getName() + " -- " + localDateTime);
		for (int i = 0; i < count; i++) {
			System.out.println("Loop# " + i);
		}
		
		try {
			System.out.println("Task#1 Sleeping For Two Seconds Start");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Task#1 Sleeping For Two Seconds Over");
	}
}
