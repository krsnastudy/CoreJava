package com.prac.core.jdks.jdk8.threads.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private final StampedLock lock = new StampedLock();
    private int x = 0;

    public void write(int value) {
        long stamp = lock.writeLock(); // write lock
        try {
            x = value;
            System.out.println(Thread.currentThread().getName() + " wrote: " + x);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void read() {
        long stamp = lock.tryOptimisticRead(); // optimistic read
        int currentValue = x;
        if (!lock.validate(stamp)) {
            // fallback to read lock
            stamp = lock.readLock();
            try {
                currentValue = x;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " read: " + currentValue);
    }

    public static void main(String[] args) {
        StampedLockExample example = new StampedLockExample();

        Thread writer = new Thread(() -> example.write(42), "Writer");
        Thread reader = new Thread(example::read, "Reader");

        writer.start();
        reader.start();
    }
}
