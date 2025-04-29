package com.prac.core.problem.companies.ibm.goldmansacs.may2022;

public class SecondMinimum {

    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 1, 6};
        printSecondMin(arr);
    }

    static void printSecondMin(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must have at least two elements");
            return;
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num < secondMin && num != firstMin) {
                secondMin = num;
            }
        }

        if (secondMin == Integer.MAX_VALUE) {
            System.out.println("No second smallest element (all elements are same?)");
        } else {
            System.out.println("Second smallest: " + secondMin);
        }
    }
}
