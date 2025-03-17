package com.prac.core.jdk5.threads.thread;

class InfiniteOddPrinter implements Runnable {
    private static int number = 1;  // Shared counter

    @Override
    public void run() {
        while (true) {
            if (number % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;  // Not thread-safe
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new InfiniteOddPrinter()).start();
        }
    }
}
