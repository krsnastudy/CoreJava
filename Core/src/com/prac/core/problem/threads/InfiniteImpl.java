package com.prac.core.problem.threads;

public class InfiniteImpl {

	public static void main(String[] args) throws InterruptedException {
		int size=5;
		InfiniteThread infyThread = new InfiniteThread();

		Thread[] tArray = new Thread[size];

		for (int i = 0; i < size; i++) {
			tArray[i] = new Thread(infyThread, "InfiniteThread[" + i + "]");
		}
		
//		Arrays.stream(tArray).forEach(i->i.start());
		
		for (Thread thread : tArray) {
			thread.start();
			thread.join();
		}
	}

}
