package com.prac.core.problem.threads;

import java.util.stream.Stream;

public class InfiniteThread implements Runnable {
	private final Object obj = new Object();

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("\n" + Thread.currentThread().getName());
			Stream.iterate(0, n -> n + 1)
				.filter(i -> i % 2 == 0)
				.filter(x -> x < 100)
				.limit(100)
				.forEach(System.out::println);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
