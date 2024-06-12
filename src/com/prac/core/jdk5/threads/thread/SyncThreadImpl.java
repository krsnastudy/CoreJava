package com.prac.core.jdk5.threads.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SyncThreadImpl {

	public static void main(String[] args) throws InterruptedException {
		ClassA o1 = new ClassA();
		ClassA o2 = new ClassA();
		Runnable r1 = new SyncThread(o1);
		Runnable r2 = new SyncThread(o2);
		
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r2, "Thread2");
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		
	/* ExecutorService */	
		ExecutorService es = Executors.newFixedThreadPool(4);
//		for(int i=0; i<2; i++) { es.execute(t1); }
//		IntStream.of(50).forEach(i-> es.execute(new SimpleTask(i)));
		IntStream.range(5, 10).forEach(i-> es.execute(new SimpleTask(i)));
		es.shutdown();
		
		//Range
        IntStream stream = IntStream.range(5, 10); 
        stream.forEach( System.out::print );  //5,6,7,8,9
         
        System.out.println();
        //Closed Range
        IntStream closedRangeStream = IntStream.rangeClosed(5, 10); 
        closedRangeStream.forEach( System.out::print );   //5,6,7,8,9,10
	}
}