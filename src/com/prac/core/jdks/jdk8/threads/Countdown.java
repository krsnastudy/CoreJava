package com.prac.core.jdks.jdk8.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Countdown {

	static int counter = 50;

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		scheduler.scheduleAtFixedRate(new Runnable() {
			int countdownStarter = 20;

			@Override
			public void run() {

//				System.out.print(countdownStarter+" ");
				System.out.println(countdownStarter);
				countdownStarter--;

				if (countdownStarter < 0) {
					System.out.println("Timer Over!");
					scheduler.shutdown();
				}
			}
		}, 0, 1, TimeUnit.SECONDS);

		/*
		System.out.println("New Scheduler");
		
		scheduler.scheduleAtFixedRate(() -> {
			System.out.println(counter);
			counter--;

			if (counter < 0) {
				System.out.println("Over .....");
				scheduler.shutdown();
			}
		}, 0, 1, TimeUnit.SECONDS);*/
	}

} // Countdown

// https://www.delftstack.com/howto/java/countdown-timer-java/