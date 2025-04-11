package com.prac.core.problem.companies.stanchart;

import java.util.Arrays;

public class RotateArray {
    static int [] arr = new int [] {1, 2, 3, 4, 5, 6, 7, 8};
    static int n = 2;
    static int[] result = new int[arr.length];

    public static void main(String[] args) {

        LeftRotate_1();
//        RightRotate_2(arr, arr.length, n);
        LeftRotate_2(arr, arr.length, n);

        System.out.println("/********* Left Shift/Move "+n+" Times ************/");
        System.out.println("Input  Array: "+ Arrays.toString(arr));
        System.out.println("Output Array: "+Arrays.toString(result));
    }

    static void LeftRotate_1(){
        for(int i=0; i<arr.length; i++){
            int newIdx = i+n >= arr.length ? (i+n)-arr.length:(i+n);
            result[i]=arr[newIdx];
//            System.out.println("Iteration - "+i +" new Index: " + newIdx +" --> "+Arrays.toString(result));
        }
    }

    static void RightRotate_2(int a[], int n, int k){
        // If rotation is greater than size of array
        k=k%n;

        for(int i = 0; i < n; i++){
            if(i<k){
                // Printing rightmost kth elements
                System.out.print(a[n + i - k]+ " ");
            }else{
                // Prints array after 'k' elements
                System.out.print(a[i - k] + " ");
            }
        }
        System.out.println();
    }

    public static void LeftRotate_2(int arr[], int d, int n){
        int p = 1;
        while (p <= d) {
            int last = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = last;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}