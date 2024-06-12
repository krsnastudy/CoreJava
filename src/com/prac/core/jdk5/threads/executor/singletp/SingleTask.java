package com.prac.core.jdk5.threads.executor.singletp;

import java.time.LocalDateTime;

public class SingleTask implements Runnable {

	@Override
	public synchronized void run() {
		
		try { 
			Thread.sleep(2000); 
		} catch
		 (InterruptedException e) { e.printStackTrace(); 
		} 
		 
		 System.out.println("ThreadName: " + Thread.currentThread().getName() + " -- " + LocalDateTime.now());
	}
}