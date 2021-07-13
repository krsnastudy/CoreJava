package com.prac.core.jdk5.threads.thread;

public class SimpleTask implements Runnable{
	private int i;
	
	SimpleTask(int i){
		this.i=i;
	}
	
	@Override
	public void run() {
		System.out.println("SimpleTask Loop: "+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
