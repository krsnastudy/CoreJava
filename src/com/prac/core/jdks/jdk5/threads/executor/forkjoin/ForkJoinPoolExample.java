package com.prac.core.jdks.jdk5.threads.executor.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("Default ForkJoinPool Size: " + commonPool.getParallelism());

        int coreSize = Runtime.getRuntime().availableProcessors();
        System.out.println("Local CPU Core Size: " + coreSize);
    }
}
