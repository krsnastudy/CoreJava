package com.prac.core.thread;

public class RunnableOne implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
		synchronized (this) {
			if((i%2==0) && Thread.currentThread().getName().equals("Thread0")) {
//				System.out.println("Even I: "+i);
				try {
					notify();
					System.out.println(i);
					wait(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if((i%2!=0) && Thread.currentThread().getName().equals("Thread1")) {
//				System.out.println("Odd I: "+i);
				try {
					notify();
					System.out.println(i);
					wait(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    }
   }//For
  }
 }
}