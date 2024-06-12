package com.prac.core.jdk8.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PassengerThread extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public PassengerThread(int duration, CyclicBarrier barrier, String pname) {
		super(pname);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " has arrived.");

			int await = barrier.await();
			
			if (await == 0) {
				System.out.println("Four Passengers have arrived so Cab is going to Start..\n");
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
