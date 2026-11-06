package com.prac.core.jdks.jdk5.threads.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Interview-oriented tour of Java's Executor framework.
 * Requires Java 17+.
 * Run: javac ExecutorFrameworkDemo.java && java ExecutorFrameworkDemo
 */
public class ExecutorFrameworkDemo {
    private static final int TASK_COUNT = 6;
    private static final int CPU_CORES = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        System.out.println("System Core Size :: "+CPU_CORES);
        System.out.println("======================Staring Executor Framework Demo====================");
        fixedThreadPool();
        cachedThreadPool();
        singleThreadExecutor();
        scheduledThreadPool();
        workStealingPool();
        boundedThreadPoolWithBackpressure();
        submitAndCollectResults();
        System.out.println("\n======================Ending Executor Framework Demo====================");
    }

    // A bounded number of workers. The factory method uses an unbounded work queue.
    private static void fixedThreadPool() throws InterruptedException {
        System.out.println("\n=== Fixed thread pool ===");
        ExecutorService executor = Executors.newFixedThreadPool(CPU_CORES);
        try {
            for (int i = 1; i <= TASK_COUNT; i++) {
                int taskId = i;
                executor.execute(() -> shortTask("fixed", taskId));
            }
        } finally {
            stop(executor);
        }
    }

    // Grows on demand and reuses idle workers; not a safe choice for unlimited bursts.
    private static void cachedThreadPool() throws InterruptedException {
        System.out.println("\n=== Cached thread pool ===");
        ExecutorService executor = Executors.newCachedThreadPool(namedFactory("cached-"));
        try {
            for (int i = 1; i <= TASK_COUNT; i++) {
                int taskId = i;
                executor.execute(() -> shortTask("cached", taskId));
            }
        } finally {
            stop(executor);
        }
    }

    // Guarantees sequential task execution; useful when order matters.
    private static void singleThreadExecutor() throws InterruptedException {
        System.out.println("\n=== Single thread executor ===");
        ExecutorService executor = Executors.newSingleThreadExecutor(namedFactory("single-"));
        try {
            for (int i = 1; i <= TASK_COUNT; i++) {
                int taskId = i;
                executor.execute(() -> shortTask("single", taskId));
            }
        } finally {
            stop(executor);
        }
    }

    // Demonstrates one-shot delay and periodic scheduling. Always shut this down.
    private static void scheduledThreadPool() throws InterruptedException {
        System.out.println("\n=== Scheduled thread pool ===");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        try {
            scheduler.schedule(() -> log("one-shot task after 100 ms"), 100, TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(
                    () -> log("periodic tick"), 0, 150, TimeUnit.MILLISECONDS);
            Thread.sleep(520); // Demo only: let several ticks happen.
        } finally {
            stop(scheduler);
        }
    }

    // Work stealing is intended for decomposable/CPU-oriented work; task order is not promised.
    private static void workStealingPool() throws InterruptedException {
        System.out.println("\n=== Work-stealing pool ===");
        ExecutorService executor = Executors.newWorkStealingPool(3);
        try {
            List<Callable<Integer>> tasks = new ArrayList<>();
            for (int i = 1; i <= TASK_COUNT; i++) {
                int value = i;
                tasks.add(() -> {
                    log("work-stealing computes " + value);
                    return value * value;
                });
            }
            // invokeAll waits for all tasks and returns Futures in input-list order.
            List<Future<Integer>> futures = executor.invokeAll(tasks);
            System.out.print("Squares in input order: ");
            for (Future<Integer> future : futures) {
                System.out.print(future.get() + " ");
            }
            System.out.println();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            stop(executor);
        }
    }

    // Explicit ThreadPoolExecutor: bounded queue + explicit rejection/backpressure policy.
    private static void boundedThreadPoolWithBackpressure() throws InterruptedException {
        System.out.println("\n=== Bounded ThreadPoolExecutor ===");
        RejectedExecutionHandler rejectionPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                              // corePoolSize
                4,                              // maximumPoolSize
                30, TimeUnit.SECONDS,           // keep-alive for excess workers
                new ArrayBlockingQueue<>(2),    // bounded queue
                namedFactory("bounded-"),
                rejectionPolicy);
        try {
            for (int i = 1; i <= 10; i++) {
                int taskId = i;
                executor.execute(() -> shortTask("bounded", taskId));
            }
        } finally {
            stop(executor);
        }
    }

    // submit() gives a Future: use get() to obtain a result or observe a task failure.
    private static void submitAndCollectResults() throws InterruptedException, ExecutionException {
        System.out.println("\n=== submit() and Future ===");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Future<Integer> result = executor.submit(() -> 20 + 22);
            System.out.println("Result from Future.get(): " + result.get());
        } finally {
            stop(executor);
        }
    }

    private static void shortTask(String pool, int taskId) {
        log(pool + " task " + taskId);
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve cancellation signal.
            log(pool + " task " + taskId + " interrupted");
        }
    }

    private static ThreadFactory namedFactory(String prefix) {
        ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        return new ThreadFactory() {
            private int nextThreadNumber = 1;

            @Override
            public synchronized Thread newThread(Runnable task) {
                Thread thread = defaultFactory.newThread(task);
                thread.setName(prefix + nextThreadNumber++);
                return thread;
            }
        };
    }

    private static void log(String message) {
        System.out.printf("[%s] %s%n", Thread.currentThread(), message);
    }

    /**
     * Graceful shutdown first, then interrupt remaining work if needed.
     */
    private static void stop(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
            List<Runnable> neverStarted = executor.shutdownNow();
            System.out.println("Forced shutdown; tasks not started: " + neverStarted.size());
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.err.println("Executor did not terminate");
            }
        }
    }
}
