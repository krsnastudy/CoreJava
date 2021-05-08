package com.prac.core.threads.executor.scheduletp;

import java.time.LocalDateTime;

public class ScheduleTask implements Runnable{

		@Override
		public synchronized void run() {
			/*
			 * if(Thread.currentThread().getId()==14) { try { Thread.sleep(1000); } catch
			 * (InterruptedException e) { e.printStackTrace(); } }
			 */
			System.out.println("ThreadName: "+Thread.currentThread().getName()+" -- "+LocalDateTime.now());
		}
	}
