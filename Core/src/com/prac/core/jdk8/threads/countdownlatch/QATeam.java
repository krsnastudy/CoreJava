package com.prac.core.jdk8.threads.countdownlatch;

public class QATeam implements Runnable {

	public QATeam(String name) {
		super();
	}

	@Override
	public void run() {
		System.out.println("Task assigned to QA team " + Thread.currentThread().getName());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Task completed by QA team " + Thread.currentThread().getName());
	}
}
