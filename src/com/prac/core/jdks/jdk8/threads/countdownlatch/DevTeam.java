package com.prac.core.jdks.jdk8.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DevTeam implements Runnable {

	private CountDownLatch countDownLatch;

	public DevTeam(CountDownLatch countDownLatch, String name) {
		super();
		this.countDownLatch = countDownLatch;
//		System.out.println("Initial Count: " + countDownLatch.getCount());
	}

	@Override
	public void run() {
		System.out.println("Task assigned to development team " + Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Each thread calls countDown() method on task completion.
		countDownLatch.countDown();
		
		System.out.println("Count Remaining: " + countDownLatch.getCount());
		System.out.println("Task completed by Dev team " + Thread.currentThread().getName()+"\n");
	}
}