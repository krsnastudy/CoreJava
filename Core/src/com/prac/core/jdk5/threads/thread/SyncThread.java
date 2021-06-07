package com.prac.core.jdk5.threads.thread;

public class SyncThread implements Runnable{
	private ClassA property;

	SyncThread(ClassA obj){
		this.property = obj;
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("In Runnable: "+Thread.currentThread().getName());
			property.m1();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
