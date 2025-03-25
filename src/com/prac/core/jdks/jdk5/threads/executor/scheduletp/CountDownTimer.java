package com.prac.core.jdks.jdk5.threads.executor.scheduletp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CountDownTimer {

	public static void main(String[] args) {
		final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

		Runnable r = new Runnable() {
			int count = 20;

			@Override
			public void run() {
				System.out.println(count);
				count--;

				if (count < 0) {
					System.out.println("Time Over!");
					service.shutdown();
				}
			}
		};

		service.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
	}
}