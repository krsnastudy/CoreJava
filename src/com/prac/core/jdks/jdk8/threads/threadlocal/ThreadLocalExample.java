package com.prac.core.jdks.jdk8.threads.threadlocal;

import lombok.SneakyThrows;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    @SneakyThrows
    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocal.set((int) (Math.random() * 100)); // each thread gets its own value
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
/*        int thread_count = 50;
        Thread[] threads = new Thread[thread_count];
        IntStream.range(1, thread_count)
                .forEach(i->{
                    int threadId = i;
                    threads[i] = new Thread(() -> {
                        System.out.println("Thread " + threadId + " running on " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                    threads[i].start();
                });*/
        // Join threads using stream
/*        for (Thread t : threads) {
            t.join();
        }*/

        System.out.println("All threads finished.");
    }
}
