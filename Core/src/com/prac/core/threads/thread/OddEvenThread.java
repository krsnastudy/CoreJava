package com.prac.core.threads.thread;

public class OddEvenThread implements Runnable{

	@Override
	public void run() {
		synchronized(this) {
		 for(int i=1; i<=10; i++) {
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
