package com.prac.core.jdk5.threads.thread;

public class OddEvenNumberPrinterLock {
    public static void main(String[] args) {
        NumberPrinterLock printer = new NumberPrinterLock(10);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}