package com.prac.core.jdk8.threads.completablefuture.oddeven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PrintOddEven {

	public static void main(String[] args) {
		
		ExecutorService evenExecutorService = Executors.newSingleThreadExecutor(r->{
			Thread t = new Thread(r);
				t.setName("even");
			return t;
		});
		
		ExecutorService oddExecutorService = Executors.newSingleThreadExecutor(r->{
			Thread t = new Thread(r);
				t.setName("odd");
			return t;
		});	
		
		IntStream.rangeClosed(1, 101)
			.forEach(num ->{
				
				CompletableFuture<Integer> evenApplyAsync = 
						CompletableFuture.completedFuture(num)
							.thenApplyAsync(x->{
								if(x%2==0) {
									System.out.println(x);
								}
								return num;
							}, 
							evenExecutorService);
				
				evenApplyAsync.join();
				
				CompletableFuture<Integer> oddApplyAsync = 
						CompletableFuture.completedFuture(num)
							.thenApplyAsync(x->{
								if(x%2!=0) {
									System.out.println(x);
								}
								return num;
							}, 
						oddExecutorService);
				
				oddApplyAsync.join();				

			}); //forEach
		
		oddExecutorService.shutdown();
		evenExecutorService.shutdown();
		
	} //psvm

}

/*

https://dzone.com/articles/print-even-and-odd-numbers-using-two-threads-compl
We are going to achieve this using Java 8 completablefuture and executor service.

We have created two single-thread executors and assigned a name to them.
Using IntStream we are iterating from 1 to 101. 
Using two completablefutures to check odd or even and calling join after the call so that the completablefuture will finish its execution.
Shutting down the executor services in the end.
*/