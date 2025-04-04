package com.prac.core.jdks.jdk8.threads.objectclassLock;

class CounterObjectLock {
    private int count = 0;

    // Object-level lock (synchronized method)
    public synchronized void increment() {
        int lCounter = count++;
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" - increment() - "+lCounter+ "  "+ count);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Object-level lock (synchronized block)
    public void decrement() {
        synchronized (this) { // Locks current object (this)
            int lCounter =  count--;
            System.out.println(Thread.currentThread().getName()+" - decrement() - "+lCounter+ "  "+ count);
        }
    }
}

