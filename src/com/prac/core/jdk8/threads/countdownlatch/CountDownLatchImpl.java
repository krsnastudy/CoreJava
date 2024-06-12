package com.prac.core.jdk8.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImpl {

	public static void main(String[] args) throws InterruptedException {
		// Created CountDownLatch for 2 threads
		CountDownLatch countDownLatch = new CountDownLatch(2);

		// Created and started two threads
		DevTeam devA = new DevTeam(countDownLatch, "dev-A");
		DevTeam devB = new DevTeam(countDownLatch, "dev-B");

		Thread teamDevA = new Thread(devA, "dev-A");
		Thread teamDevB = new Thread(devB, "dev-B");

		teamDevA.start();
		teamDevA.join();
		teamDevB.start();

		// When two threads(dev-A and dev-B)completed tasks are returned
		countDownLatch.await();

		// Now execution of thread(QA team) started..
		QATeam qa = new QATeam("QA team");
		Thread qaTeam = new Thread(qa, "QA team");
		qaTeam.start();
	}
}


/*

https://www.geeksforgeeks.org/difference-between-countdownlatch-and-cyclicbarrier-in-java/

CountDownLatch is a thread waiting for multiple threads to finish or calling countDown(). 
When all threads have called countDown(), the awaiting thread continues to execute.

CountDownLatch is a synchronization aid that allows one or more threads to 
wait until a set of operations being performed in other threads completes.

https://github.com/kishanjavatrainer/CountDownLatchExample
https://www.youtube.com/watch?v=59oQfkdn5mA&ab_channel=KKJavaTutorials

*/