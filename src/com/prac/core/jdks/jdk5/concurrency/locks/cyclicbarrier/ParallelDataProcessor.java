package com.prac.core.jdks.jdk5.concurrency.locks.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParallelDataProcessor {

    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        // Define a CyclicBarrier for synchronization after each phase
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
            System.out.println("🔄 All threads completed phase. Proceeding to next...\n");
        });

        // Start worker threads
        for (int i = 1; i <= THREAD_COUNT; i++) {
            new Thread(new DataProcessor("Worker-" + i, barrier)).start();
        }
    }
}

class DataProcessor implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public DataProcessor(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            processPhase("Step 1: Load Data");
            barrier.await(); // Wait for others

            processPhase("Step 2: Transform Data");
            barrier.await(); // Wait for others

            processPhase("Step 3: Save Data");
            barrier.await(); // Final sync

            System.out.println(name + " ✅ Completed all phases.\n");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void processPhase(String phase) throws InterruptedException {
        System.out.println(name + " ➤ " + phase);
        Thread.sleep((long) (Math.random() * 2000)); // Simulate processing time
    }
}
