package com.prac.core.jdks.jdk5.threads.thread;

class InfiniteOddPrinter_Synchronized implements Runnable {
    private static int number = 1;  // Shared counter

    @Override
    public void run() {
        while (true) {
            printOdd();
        }
    }

    private synchronized void printOdd() {
        if (number % 2 != 0) {
            System.out.println(Thread.currentThread().getName() + " -> " + number);
            number++; // Only one thread can modify at a time
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new InfiniteOddPrinter_Synchronized()).start();
        }
    }
}

