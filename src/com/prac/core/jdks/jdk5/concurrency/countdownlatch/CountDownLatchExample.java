package com.prac.core.jdks.jdk5.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // Worker Threads
        for (int i = 1; i <= threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " finished its task.");
                latch.countDown(); // Decrement latch count
            }, "Worker-" + i).start();
        }

        System.out.println("Main thread waiting for workers...");
        latch.await(); // Wait for latch to reach 0
        System.out.println("All workers are done. Main thread proceeding.");
    }
}