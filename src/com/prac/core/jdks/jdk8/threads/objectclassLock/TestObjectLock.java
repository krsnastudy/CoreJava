package com.prac.core.jdks.jdk8.threads.objectclassLock;

public class TestObjectLock {
    public static void main(String[] args) {
        Printer printer1 = new Printer();
        Printer printer2 = new Printer();

        Runnable task1 = () -> printer1.print("Hello from printer1");
        Runnable task2 = () -> printer2.print("Hello from printer2");

        Runnable disp1 = () -> printer1.display("display from printer1");
        Runnable disp2 = () -> printer2.display("display from printer2");

        new Thread(task1).start();
        new Thread(task2).start(); // Can run in parallel as objects are different

        new Thread(disp1).start();
        new Thread(disp2).start();

        Runnable taskStatic1 = () -> Printer.printStatic("Static print 1");
        Runnable taskStatic2 = () -> Printer.printStatic("Static print 2");

        new Thread(taskStatic1).start();
        new Thread(taskStatic2).start(); // Will execute one after another
    }
}
