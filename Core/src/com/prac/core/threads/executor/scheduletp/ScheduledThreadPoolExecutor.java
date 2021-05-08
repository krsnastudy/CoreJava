package com.prac.core.threads.executor.scheduletp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutor {

	public static void main(String[] args) throws InterruptedException{

		System.out.println("ScheduledThreadPoolExecutor Started");
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		System.out.println("service.schedule");
		
			/** ScheduledFuture<?> java.util.concurrent.ScheduledExecutorService.schedule
			 * 			(Runnable command, long delay, TimeUnit unit)*/
		
		// task to run after 2 Seconds delay -- Initial Delay
			service.schedule(new ScheduleTask(), 2, TimeUnit.SECONDS);
		
		System.out.println("\nservice.scheduleAtFixedRate");
			/** ScheduledFuture<?> java.util.concurrent.ScheduledExecutorService.scheduleAtFixedRate
			 		(Runnable command, long initialDelay, long period, TimeUnit unit) */
		
		// task to run with initial delay 5 sec, repeatedly run for every 5 Seconds			
			service.scheduleAtFixedRate(new ScheduleTask(), 5, 6, TimeUnit.SECONDS);
		
		System.out.println("\nservice.scheduleWithFixedDelay");
			/** ScheduledFuture<?> java.util.concurrent.ScheduledExecutorService.scheduleWithFixedDelay
			 * 	(Runnable command, long initialDelay, long delay, TimeUnit unit) */
		
		// task to run repeatedly every 2 Seconds after previous task completion			
			service.scheduleWithFixedDelay(new ScheduleTask(), 3, 4, TimeUnit.SECONDS);
		
		System.out.println("ScheduledThreadPoolExecutor Finished");
		
		/*** Active Threads ****/
		Thread.sleep(1000);
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
            System.out.println("Thread: "+threadList[i].getName());
        }
        System.out.println();		
	}
	

}
