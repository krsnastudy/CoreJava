package com.prac.core.threads.thread;

public class PrintOddEven {

	public static void main(String[] args) throws InterruptedException{
		Runnable r = new OddEvenThread();
		Thread t1 = new Thread(r, "first");
		Thread t2 = new Thread(r, "second");
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		/*** Display All Running Threads ***/
		
		// getting the group of the threads/
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
  
        // getting the total active count of the threads
        int threadCount = threadGroup.activeCount();
  
        Thread threadList[] = new Thread[threadCount];
        // enumerating over the thread list
        threadGroup.enumerate(threadList);
  
        System.out.println("\nActive threads are:");
        
        // iterating over the for loop to get the names of
        // all the active threads.
        for (int i = 0; i < threadCount; i++)
            System.out.println(threadList[i].getName());
        
        t1.stop();
        t2.stop();
        
    } //psvm
} // PrintOddEven
