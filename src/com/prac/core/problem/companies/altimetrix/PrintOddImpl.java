package com.prac.core.problem.companies.altimetrix;

import java.util.stream.Stream;

public class PrintOddImpl {

	public static void main(String[] args) throws InterruptedException {
		
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});

//		t.start();
//		t.stop();

		int size = 1;

		Runnable r = new Runnable() {
			private Object object = new Object();
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				synchronized(object) {
					try {
						Stream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);
//						notifyAll();
//						wait();
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} //run()
		};

		Thread[] tArray = new Thread[size];
/*
		tArray[0] = new Thread(r, "RunnableThread-" + 0);
		tArray[0].start();
		tArray[0].join();
		
		tArray[1] = new Thread(r, "RunnableThread-" + 1);
		tArray[1].start();
		tArray[1].join();
*/
//		Arrays.stream(tArray).forEach(i->new Thread(r, "RunnableThread-"+i).start());
//		Arrays.stream(tArray).forEach(i-> tArray[i]=new Thread(r, "RunnableThread-"+i));
//		for(int i : tArray.length) 
		
		for (int i = 0; i < tArray.length; i++) {
			tArray[i] = new Thread(r, "RunnableThread-" + i);
			//tArray[i].start();
			//tArray[i].join();
		}
		
		
		OddEvenThread oe = new OddEvenThread();
		
		Thread printOdd = new Thread(oe, "odd");
		Thread printEven = new Thread(oe, "even");
		
		printOdd.start();
		printEven.start();
	}

}
