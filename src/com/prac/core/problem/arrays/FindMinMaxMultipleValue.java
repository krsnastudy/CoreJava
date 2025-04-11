package com.prac.core.problem.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMinMaxMultipleValue {

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, iMax1 = 0, iMax2 = 0, iMin1 = 0, iMin2 = 0;
        int[] iArr = {1, 6, 8, 9, 11, 5, 2, 7, 4, -5, 12, -2};
        System.out.println("Before Sorting " + Arrays.toString(iArr));
        Arrays.sort(iArr);
        System.out.println("After  Sorting " + Arrays.toString(iArr));

        /** Finding Max Multiplication Value **/
        for (int i = 0; i < iArr.length; i++) {
            for (int j = i + 1; j < iArr.length; j++) {
                int product = iArr[i] * iArr[j];
                if (product > max) {
                    max = product;
                    iMax1 = iArr[i];
                    iMax2 = iArr[j];
                }
            }
        }
        System.out.println("\nLogic1: Max Multiplication Value [" + iMax1 + ", " + iMax2 + "] " + "is : " + max);

        int arrLen = iArr.length;
        int maxProd1 = iArr[0] * iArr[1];
        int maxProd2 = iArr[arrLen - 2] * iArr[arrLen - 1];
        int maxValue = 0;
        if (maxProd1 > maxProd2) {
            maxValue = maxProd1;
            iMax1 = iArr[0];
            iMax2 = iArr[1];
        } else {
            maxValue = maxProd2;
            iMax1 = iArr[arrLen - 2];
            iMax2 = iArr[arrLen - 1];
        }
        System.out.println("Logic2: Max Multiplication Value [" + iMax1 + ", " + iMax2 + "] " + "is : " + maxValue);

        int maxIdx = iArr.length - 1;
        int maxB4Idx = maxIdx - 1;
        int logic3MaxValue = iArr[maxIdx] * iArr[maxB4Idx];
        System.out.println("Logic3: Max Multiplication Value [" + iArr[maxB4Idx] + ", " + iArr[maxIdx] + "] " + "is : " + logic3MaxValue);

        /** Finding Min Multiplication Value **/
        for (int i = 0; i < iArr.length; i++) {
            for (int j = i + 1; j < iArr.length; j++) {
                int product = iArr[i] * iArr[j];
                if (product < min) {
                    min = product;
                    iMin1 = iArr[i];
                    iMin2 = iArr[j];
                }
            }
        }
        System.out.println("\nLogic1 Min Multiplication Value [" + iMin1 + ", " + iMin2 + "] " + "is : " + min);

        int minMax = Arrays.stream(iArr).max().getAsInt() * Arrays.stream(iArr).min().getAsInt();
        System.out.println("Logic2 Min Multiplication Value [" + Arrays.stream(iArr).min().getAsInt() + ", " + Arrays.stream(iArr).max().getAsInt() + "] " + "is : " + minMax);
    }
}
