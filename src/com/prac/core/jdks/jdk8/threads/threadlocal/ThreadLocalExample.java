package com.prac.core.jdks.jdk8.threads.threadlocal;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocal.set((int) (Math.random() * 100)); // each thread gets its own value
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
