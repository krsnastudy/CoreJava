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

/**
 *
 * lock.tryOptimisticRead() :
 * Returns a stamp that can later be validated, or zero if exclusively locked.
 * Returns: a valid optimistic read stamp, or zero if exclusively locked
 *
 *
 * lock.validate(stamp) :
 * Returns true if the lock has not been exclusively acquired since issuance of the given stamp. Always returns false if the stamp is zero.
 * Always returns true if the stamp represents a currently held lock. Invoking this method with a value not obtained from tryOptimisticRead
 * or a locking method for this lock has no defined effect or result.
 * Params:
 * stamp – a stamp
 * Returns: true if the lock has not been exclusively acquired since issuance of the given stamp; else false
 *
 *
 * lock.unlockRead(stamp):
 * If the lock state matches the given stamp, releases the non-exclusive lock.
 * Params:
 * stamp – a stamp returned by a read-lock operation
 * Throws:
 * IllegalMonitorStateException – if the stamp does not match the current state of this lock
 *
 * */