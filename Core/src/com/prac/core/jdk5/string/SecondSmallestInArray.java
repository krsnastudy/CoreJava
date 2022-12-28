package com.prac.core.jdk5.string;

public class SecondSmallestInArray {
    public static void main(String args[]) {
        int arr[] = {12, 13, 1, 10, 34, 1};
        int n = arr.length;
        int smallest = Integer.MAX_VALUE;
        System.out.println("smallest: "+smallest);
        // traversing the array to find smallest element.
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("smallest element is: "+ smallest);

        int second_smallest = Integer.MAX_VALUE;

        // traversing the array to find second smallest element
        for (int i = 0; i < n; i++) {
            if (arr[i] < second_smallest
                    && arr[i] > smallest) {
                second_smallest = arr[i];
            }
        }
        System.out.println("second smallest element is: "+ second_smallest);
    }
}

/*
 https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
*/