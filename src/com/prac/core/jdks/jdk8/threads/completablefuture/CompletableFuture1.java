package com.prac.core.jdks.jdk8.threads.completablefuture;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuture1 {

	public static void main(String[] args) throws InterruptedException {
		int count = 2;

		Runnable rOne = new TaskOne(count);
		Runnable rTwo = new TaskTwo(count);
		Runnable rThree = new TaskThree(count);

		Thread t1 = new Thread(rOne, "ThreadOne");
		Thread t2 = new Thread(rTwo, "ThreadTwo");
		Thread t3 = new Thread(rThree, "ThreadThree");

		t1.start();
//		CompletableFuture<Void> future = CompletableFuture.runAsync(rTwo);
		CompletableFuture.runAsync(rTwo);
		t3.start();
//		CompletableFuture.runAsync(rOne);
//		CompletableFuture.runAsync(rOne);

		// Using Lambda Expression
//		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		CompletableFuture.runAsync(() -> {
			try {
				// Call the Save Method
				System.out.println("Individual Task CompletableFuture.runAsync() -- " + LocalDateTime.now());
				TimeUnit.SECONDS.sleep(4);
//				TimeUnit.MINUTES.sleep(1); // not working
				System.out.println("Individual Task CameOut");
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
	}
}