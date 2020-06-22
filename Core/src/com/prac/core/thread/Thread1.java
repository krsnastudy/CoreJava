package com.prac.core.thread;

public class Thread1 {

	public static void main(String[] args) throws InterruptedException {

		RunnableOne r1 = new RunnableOne();
		Thread[] t = new Thread[2];
		
		for(int i=0; i<t.length; i++) {
			String name = "Thread"+i;
			
			t[i] = new Thread(r1);
			t[i].setName(name);
			
			System.out.println("Name: "+t[i].getName()+" Id:"+t[i].getId());
			t[i].start();
//			t[i].wait(12);
//			t[i].join();
		}
		
	}
}
