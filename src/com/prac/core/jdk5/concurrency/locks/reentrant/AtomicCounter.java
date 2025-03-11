package com.prac.core.jdk5.concurrency.locks.reentrant;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Thread-safe increment
    }

    public int getCount() {
        return count.get();
    }
}
