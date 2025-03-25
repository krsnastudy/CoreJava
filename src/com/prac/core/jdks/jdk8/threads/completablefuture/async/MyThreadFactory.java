package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger threadNumber = new AtomicInteger(1);
    private String threadNamePrefix = "";

    public MyThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, threadNamePrefix + threadNumber.getAndIncrement());
    }
}