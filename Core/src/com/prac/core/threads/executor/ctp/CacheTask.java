package com.prac.core.threads.executor.ctp;

import java.time.LocalDateTime;

public class CacheTask implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(5000);	
		}catch(InterruptedException e) { e.printStackTrace(); }
		
		System.out.println("ThreadName: "+Thread.currentThread().getName()+" "+LocalDateTime.now());
	}
}
