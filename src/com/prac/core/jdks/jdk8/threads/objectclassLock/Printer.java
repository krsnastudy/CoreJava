package com.prac.core.jdks.jdk8.threads.objectclassLock;

public class Printer {
    public synchronized void print(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    public void display(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    public static synchronized void printStatic(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }
}
