package com.prac.core.jdks.jdk5.string;

import java.util.Arrays;

public class SmallestInArray {
    public static void main(String[] args) {
        Integer b[] = {44, 66, 99, 77, 33, 22, 55};
        int x = Arrays.stream(b).sorted().findFirst().get();
        System.out.println("Jdk 8 : " + x);
        int temp;
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] > b[j]) {
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        System.out.println("Jdk 6 : " + b[0]);
    }
}
