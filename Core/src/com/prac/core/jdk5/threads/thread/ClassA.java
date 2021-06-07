package com.prac.core.jdk5.threads.thread;

public class ClassA {

	synchronized void m1() throws InterruptedException{
		System.out.println("ClassA: "+Thread.currentThread().getName());
		Thread.sleep(5000);
		System.out.println("Sleep is Done: "+Thread.currentThread().getId());
	}
}
