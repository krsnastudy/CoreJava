package com.prac.core.jdks.jdk5.concurrency.locks.reentrant;

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();
        AtomicCounter atomicCounter = new AtomicCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                atomicCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1009; i++) {
                counter.increment();
                atomicCounter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount()); // Output: 2000
        System.out.println("Final atomicCounter: " + atomicCounter.getCount());
    }
}