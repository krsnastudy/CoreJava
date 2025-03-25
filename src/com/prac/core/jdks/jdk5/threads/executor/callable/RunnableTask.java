package com.prac.core.jdks.jdk5.threads.executor.callable;

public class RunnableTask implements Runnable {
	private int num = 0;

	public RunnableTask(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Runnable: "+threadName + " : Started Task...");

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + threadName + " : " + num);
			num = num + i;
			Callable_Runnable_Ex.sleep(1);
		}
		System.out.println("Runnable "+threadName + " : Completed Task. Final Value : " + num);
	}
}