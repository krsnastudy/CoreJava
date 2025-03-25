package com.prac.core.jdks.jdk5.threads.thread;

public class FirstThread {

	public static void main(String[] args) {
		Printer p = new Printer();
		Runnable m = new MyThread(p);
		
		/*Runnable Interface Implementation */
		
		// Runnable Declaration 1
		Thread t1 = new Thread(m, "I");
		t1.start();		

		// Runnable Declaration 2		
		new Thread(m, "II").start();
		
		// Runnable Declaration 3		
		Thread t4 = new Thread(new MyThread(p), "III");
		t4.start();
		
		/*Extend Thread Class*/
		YourThread t3 = new YourThread(p);
		t3.setName("IV");
		t3.start();
	}

}

class MyThread implements Runnable{
	Printer pRef;
	
	MyThread(Printer p){
		pRef = p;
	}
	
	@Override
	public void run(){
		pRef.printDocuments(10, Thread.currentThread().getName()+".pdf", Thread.currentThread().getName());
	}
	
}

class YourThread extends Thread{
	Printer pRef;
	
	YourThread(Printer p){
		pRef = p;
	}
	
	@Override
	public void run(){
		pRef.printDocuments(10, Thread.currentThread().getName()+".pdf", Thread.currentThread().getName());
	}
}