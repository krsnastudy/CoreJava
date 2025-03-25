package com.prac.core.jdks.jdk5.threads.executor.callable;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable_Runnable_Ex {
	public static int coreLength;
	
	static {
		coreLength = Runtime.getRuntime().availableProcessors();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Main Thread start...");
		Instant start = java.time.Instant.now();

		runnableThreads();
		callableThreads();

		Instant end = java.time.Instant.now();
		Duration between = java.time.Duration.between(start, end);
		System.out.format("Time taken : %02d:%02d.%04d \n", between.toMinutes(), between.getSeconds(),
				between.toMillis());

		System.out.println("Main Thread completed...");
	}

	public static void runnableThreads() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(coreLength);
		Future<?> f1 = executor.submit(new RunnableTask(5));
		Future<?> f2 = executor.submit(new RunnableTask(2));
		Future<?> f3 = executor.submit(new RunnableTask(1));

		// Waits until pool-thread complete, return null upon successful completion.
		System.out.println("F1 : " + f1.get());
		System.out.println("F2 : " + f2.get());
		System.out.println("F3 : " + f3.get());

		executor.shutdown();
	}

	public static void callableThreads() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(coreLength);
		Future<Integer> f1 = executor.submit(new CallableTask(5));
		Future<Integer> f2 = executor.submit(new CallableTask(2));
		Future<Integer> f3 = executor.submit(new CallableTask(1));

		// Waits until pool-thread complete, returns the result.
		System.out.println("CallableTask F1 : " + f1.get());
		System.out.println("CallableTask F2 : " + f2.get());
		System.out.println("CallableTask F3 : " + f3.get());

		executor.shutdown();
	}

	@SuppressWarnings("static-access")
	public static void sleep(int i) {
		try {
			Thread.currentThread().sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}