package com.prac.core.jdk5.threads.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

	public static void main(String[] args) {
		Runnable runnable = new Thread3(10);
		
		/*
		 * Thread t1 = new Thread(runnable,"t1"); Thread t2 = new Thread(runnable,"t2");
		 * Thread t3 = new Thread(runnable,"t3"); Thread t4 = new Thread(runnable,"t4");
		 * 
		 * t1.start(); t2.start(); t3.start(); t4.start();
		 */
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		es.execute(runnable);
		es.shutdown();
	}

}
