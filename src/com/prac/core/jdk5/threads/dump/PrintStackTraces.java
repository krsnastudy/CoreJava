package com.prac.core.jdk5.threads.dump;

import java.util.Arrays;

public class PrintStackTraces {
    public static void main(String[] args) {
        Thread.getAllStackTraces().forEach((t, s) -> {
            System.out.println(t.getName() + ": " + Arrays.toString(s));
        });
    }
}
