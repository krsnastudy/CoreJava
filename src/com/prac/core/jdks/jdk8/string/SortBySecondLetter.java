package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;

public class SortBySecondLetter {
    public static void main(String[] args) {
        String[] sArr = {"Elephant", "Dumble", "Cat", "Apple", "Bat"};
        System.out.println("Before : " + Arrays.toString(sArr));
//        int idx = 2;
//        Arrays.sort(sArr, Comparator.comparing(s -> ((s.length() > 1) && (idx > 0)) ? s.charAt(idx - 1) : Character.MIN_VALUE));

        Arrays.sort(sArr, Comparator.comparing(s -> s.length() > 1 ? s.charAt(1) : Character.MIN_VALUE));
        System.out.println("After  : " + Arrays.toString(sArr));

    }
}
