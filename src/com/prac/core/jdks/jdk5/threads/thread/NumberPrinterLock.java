package com.prac.core.jdks.jdk5.threads.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinterLock {
    private int number = 1;
    private final int max;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public NumberPrinterLock(int max) {
        this.max = max;
    }

    public void printOdd() {
        try {
            lock.lock();
            while (number < max) {
                while (number % 2 == 0) {
                    condition.await();
                }
                System.out.println("Odd: " + number);
                number++;
                condition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        try {
            lock.lock();
            while (number <= max) {
                while (number % 2 != 0) {
                    condition.await();
                }
                System.out.println("Even: " + number);
                number++;
                condition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}