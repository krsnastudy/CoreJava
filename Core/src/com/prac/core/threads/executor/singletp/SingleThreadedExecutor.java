package com.prac.core.threads.executor.singletp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutor {

	public static void main(String[] args) throws InterruptedException{
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		for(int i=1; i<=5; i++) {
			service.submit(new SingleTask());	
		}
	}

}
