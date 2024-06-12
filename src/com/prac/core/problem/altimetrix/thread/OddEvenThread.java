package com.prac.core.problem.altimetrix.thread;

public class OddEvenThread implements Runnable {

	@Override
	public void run() {
		
		for(int i=1; i<=100; i++) {
			synchronized (this) {
				try {
					if(i%2==0 && Thread.currentThread().getName().equals("even")) {
						notify();
						System.out.println(i);
						wait();
					}else if(i%2!=0 && Thread.currentThread().getName().equals("odd")) {
						notify();
						System.out.println(i);
						wait();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
