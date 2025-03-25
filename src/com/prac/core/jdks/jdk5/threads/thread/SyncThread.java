package com.prac.core.jdks.jdk5.threads.thread;

public class SyncThread implements Runnable{
	private ClassA property;

	SyncThread(ClassA obj){
		this.property = obj;
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("Runnable Thread: "+Thread.currentThread().getName());
			property.m1();
			System.out.println();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
