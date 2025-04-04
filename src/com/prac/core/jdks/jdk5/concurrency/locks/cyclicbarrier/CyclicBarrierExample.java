package com.prac.core.jdks.jdk5.concurrency.locks.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int threadCount = 3;

        // Barrier Action (executed once all threads reach the barrier)
        Runnable barrierAction = () -> System.out.println("All threads reached the barrier. Let's proceed!\n");

        // Create CyclicBarrier for 3 threads
        CyclicBarrier barrier = new CyclicBarrier(threadCount, barrierAction);

        // Launch 3 threads
        for (int i = 1; i <= threadCount; i++) {
            Thread t = new Thread(new Task(barrier), "Thread-" + i);
            t.start();
        }
    }

    static class Task implements Runnable {
        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is performing some work...");

            try {
                Thread.sleep((long) (Math.random() * 3000)); // Simulate work
                System.out.println(name + " is waiting at the barrier...");
                barrier.await(); // Wait for others

                // Continue after all threads reach the barrier
                System.out.println(name + " continues execution.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
