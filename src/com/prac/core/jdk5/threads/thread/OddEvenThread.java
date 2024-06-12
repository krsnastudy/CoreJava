package com.prac.core.jdk5.threads.thread;

public class OddEvenThread implements Runnable{
	int count;
	
	public OddEvenThread(int count) {
		super();
		this.count = count;
	}


	@Override
	public void run() {
		synchronized(this) {
		 for(int i=1; i<=count; i++) {
		  try {
				if(i%2==0 && Thread.currentThread().getName().equalsIgnoreCase("second")) {
					notify();
//					System.out.println("EvenNumber:"+i);
					System.out.println(i);
					wait();
				}else if(i%2!=0 && Thread.currentThread().getName().equalsIgnoreCase("first")) {
					notify();
//					System.out.println("OddNumber:"+i);
					System.out.println(i);
					wait();
				}
			  
			} catch (Exception e) {
				e.printStackTrace();
			} // catch
		 }// for
	} // synchronized
  } // run()
}// OddEvenThread
