package com.prac.core.jdk5.threads.thread;

public class SyncThreadImpl {

	public static void main(String[] args) throws InterruptedException {
		ClassA o1 = new ClassA();
		ClassA o2 = new ClassA();
		Runnable r1 = new SyncThread(o1);
		Runnable r2 = new SyncThread(o2);
		
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r2, "Thread2");
		
		t1.start();
		t1.join();
		t2.start();
	}

}
