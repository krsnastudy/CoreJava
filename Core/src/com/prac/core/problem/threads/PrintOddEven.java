package com.prac.core.problem.threads;

public class PrintOddEven {

	public static void main(String[] args) {
		int limit =100;
		Runnable oet = new OddEvenThread(limit);
		
		Thread even = new Thread(oet, "even");
		Thread odd = new Thread(oet, "odd"); 
		
		odd.start();
		even.start();
		
//		odd.stop();
//		even.stop();
	}

}
