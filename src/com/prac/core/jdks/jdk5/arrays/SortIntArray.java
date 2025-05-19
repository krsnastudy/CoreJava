package com.prac.core.jdks.jdk5.arrays;

import java.util.Arrays;
import java.util.Collections;

public class SortIntArray {
    public static void main(String[] args) {
        int[] iArr = {1, 6, 8, 7, 2};
        System.out.println("B4 Sort :: " + Arrays.toString(iArr));

        //Sorting an Array
        Integer[] wArr = Arrays.stream(iArr).boxed().toArray(Integer[]::new);
        Arrays.sort(wArr, Collections.reverseOrder());

        int[] sArr = Arrays.stream(wArr).mapToInt(i -> i).toArray();

        System.out.println("A4 Sort :: " + Arrays.toString(sArr));
    }
}
