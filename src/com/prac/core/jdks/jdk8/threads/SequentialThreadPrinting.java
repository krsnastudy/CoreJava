package com.prac.core.jdks.jdk8.threads;

class SequencePrinter {
    private int number = 0;
    private final int max = 10; // Number of times each thread prints
    private final int numThreads = 3;

    public synchronized void printNumber(int threadId) {
        for (int i = 0; i < max; i++) {
            while (number % numThreads != threadId) {
                try {
                    wait(); // Wait if it's not this thread's turn
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread-" + (threadId + 1) + " : " + (number + 1));
            number++;
            notifyAll(); // Notify all waiting threads
        }
    }
}

public class SequentialThreadPrinting {
    public static void main(String[] args) {
        SequencePrinter printer = new SequencePrinter();

        Thread t1 = new Thread(() -> printer.printNumber(0));
        Thread t2 = new Thread(() -> printer.printNumber(1));
        Thread t3 = new Thread(() -> printer.printNumber(2));

        t1.start();
        t2.start();
        t3.start();
    }
}
