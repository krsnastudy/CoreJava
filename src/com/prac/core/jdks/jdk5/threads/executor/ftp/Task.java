package com.prac.core.jdks.jdk5.threads.executor.ftp;

import java.time.LocalDateTime;

public class Task implements Runnable{

	@Override
	public synchronized void run() {
		/*
		 * if(Thread.currentThread().getId()==14) { try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); } }
		 */
		System.out.println("ThreadName: "+Thread.currentThread().getName()+" "+LocalDateTime.now());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
