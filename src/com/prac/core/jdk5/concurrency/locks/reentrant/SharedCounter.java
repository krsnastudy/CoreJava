package com.prac.core.jdk5.concurrency.locks.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock(); // Explicit Lock

    public void increment() {
        lock.lock(); // Acquire lock
        try {
            count++;
        } finally {
            lock.unlock(); // Always release lock
        }
    }

    public int getCount() {
        return count;
    }
}


