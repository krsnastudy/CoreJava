package com.prac.core.problem.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileExample {

	public static void main(String[] args) throws InterruptedException {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("No Of Cores Available are: "+coreCount);
		Counter counter = new Counter();
		Thread[] thread = new Thread[coreCount];
		
		/*
		 * for(int i =0; i<coreCount; i++) { thread[i] = new VolatileThread(counter);
		 * thread[i].start(); thread[i].join(); }
		 */

//		System.out.println("ExecutorService");
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		
		for(int i=0; i<15; i++) {
			service.execute(new VolatileThread(counter));	
		}
		service.shutdown();
		service.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
	}

}
