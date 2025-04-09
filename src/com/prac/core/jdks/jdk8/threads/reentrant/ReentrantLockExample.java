package com.prac.core.jdks.jdk8.threads.reentrant;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock(); // acquire lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented to: " + count);
            System.out.println(Thread.currentThread().getName()+" Sleep Started "+ Instant.now());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+" Sleep Ended "+ Instant.now());
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // release lock
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample counter = new ReentrantLockExample();
        Runnable task = counter::increment;

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
}
