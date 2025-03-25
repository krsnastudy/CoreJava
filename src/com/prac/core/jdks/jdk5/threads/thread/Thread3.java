package com.prac.core.jdks.jdk5.threads.thread;

public class Thread3 implements Runnable{
private int var;

	public Thread3(int i) {
		this.var = i;
	}

	@Override
	public void run() {
		for(int i=0; i<var; i++) {
			Example1 ex = new Example1();
			
			try {
				ex.m1();
				ex.m2();
				ex.m3();
				ex.m4();
		System.out.println("CurrentThread Name: "+Thread.currentThread().getName());
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
