package com.prac.core.jdks.jdk8.threads.deadlock;

public class DeadlockExample {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (Lock1) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (Lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (Lock2) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (Lock1) {
                    System.out.println("Thread 2 acquired both locks");
                }
            }
        });

        t1.start();
        t2.start();

        // Wait for potential deadlock to happen
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        // Call deadlock detector
        DeadlockDetector.detectDeadlock();
    }
}
