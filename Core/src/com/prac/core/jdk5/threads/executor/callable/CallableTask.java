package com.prac.core.jdk5.threads.executor.callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
	private int num = 0;

	public CallableTask(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		String threadName = Thread.currentThread().getName();
		System.out.println("Callable "+threadName + " : Started Task..."+ num);

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + threadName + " : " + num);
			num = num + i;
			Callable_Runnable_Ex.sleep(1);
		}
		System.out.println("Callable ("+threadName +") Completed Task. Final Value : " + num);

		return num;
	}
}