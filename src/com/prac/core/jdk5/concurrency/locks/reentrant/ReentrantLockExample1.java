package com.prac.core.jdk5.concurrency.locks.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample1 {

	public static void main(String[] args) {

		System.out.println("ThreadName: " + Thread.currentThread().getThreadGroup().getName());
		System.out.println("ParentThreadName: " + Thread.currentThread().getThreadGroup().getParent().getName() + "\n");

		ReentrantLock l = new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println("isLocked(): " + l.isLocked());
		System.out.println("getHoldCount(): " + l.getHoldCount());
		System.out.println("isHeldByCurrentThread(): " + l.isHeldByCurrentThread());
		System.out.println("getQueueLength(): " + l.getQueueLength());
		l.unlock();
		System.out.println("getHoldCount(): " + l.getHoldCount());
		System.out.println("isLocked(): " + l.isLocked());
		l.unlock();
		System.out.println("isLocked(): " + l.isLocked());
		System.out.println("isFair(): " + l.isFair());
	}
}
