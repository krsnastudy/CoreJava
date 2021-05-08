package com.prac.core.threads.executor.ctp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor{

	public static void main(String[] args) throws InterruptedException{

		System.out.println("CachedThreadPoolExecutor Started");
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i=1;i<=10;i++) {
			service.execute(new CacheTask());
		}
		
		System.out.println("CachedThreadPoolExecutor Finished");
		
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
