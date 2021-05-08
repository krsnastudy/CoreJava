package com.prac.core.threads.executor.ftp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {

	public static void main(String[] args) throws InterruptedException{
		
		int cpuCoreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("CPU Cores: "+cpuCoreCount);
		
		ExecutorService service = Executors.newFixedThreadPool(cpuCoreCount);
		
		System.out.println("FixedThreadPoolExecutor Started");
		
		for(int i=0; i<30; i++) {
			service.execute(new Task());
		}
		
		System.out.println("FixedThreadPoolExecutor Finished");
		
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
