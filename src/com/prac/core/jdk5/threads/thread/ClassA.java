package com.prac.core.jdk5.threads.thread;

public class ClassA {

	synchronized void m1() throws InterruptedException{
		System.out.println("In ClassA: "+Thread.currentThread().getName());
		Thread.sleep(6000);
//		Thread.currentThread().wait(5000);
		System.out.println("Sleep: "+Thread.currentThread().getName()+"-"+Thread.currentThread().getId());
	}
}
