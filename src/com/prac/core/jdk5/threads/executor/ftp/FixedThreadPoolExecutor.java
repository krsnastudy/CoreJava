package com.prac.core.jdk5.threads.executor.ftp;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExecutor {

	public static void main(String[] args) throws InterruptedException{
		
		int cpuCoreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("CPU Cores: "+cpuCoreCount);
		
		ExecutorService service = Executors.newFixedThreadPool(cpuCoreCount);
		
		System.out.println("FixedThreadPoolExecutor Started");
		
		for(int i=0; i<30; i++) {
			service.execute(new Task());
			
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("ThreadName: "+Thread.currentThread().getName()+" "+LocalDateTime.now());
				}
			});
		}
		
		System.out.println("FixedThreadPoolExecutor Finished");
		
		service.shutdown();
		service.awaitTermination(20, TimeUnit.SECONDS);
		
	/*** Active Threads ****/
		Thread.sleep(10000);
		// getting the group of the threads/
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        
        // getting the total active count of the threads
        int threadCount = threadGroup.activeCount();
        System.out.println("\nThreads Count: "+threadCount+", their names as below");
        
        Thread threadList[] = new Thread[threadCount];
        // enumerating over the thread list
        threadGroup.enumerate(threadList);
        
        // iterating over the for loop to get the names of
        // all the active threads.
        for (int i = 0; i < threadCount; i++) {
            System.out.println("threadGroup: "+threadList[i].getName());
        }
        System.out.println();
	}
}
