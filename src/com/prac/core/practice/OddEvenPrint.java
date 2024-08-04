package com.prac.core.practice;

import java.util.Random;

public class OddEvenPrint implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        OddEvenPrint oe = new OddEvenPrint();

        Thread t1 = new Thread(oe, "t1");
        Thread t2 = new Thread(oe, "t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                if (i % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("t2")) {
                    try {
                        notifyAll();
                        System.out.println(i);
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (i % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("t1")) {
                    try {
                        notify();
                        System.out.println(i);
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
