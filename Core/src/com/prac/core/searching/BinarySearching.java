package com.prac.core.searching;

import java.util.Arrays;

public class BinarySearching {

	int binSearch(int arr[], int x) {
	System.out.println("\nSearching for "+x);
	
		int len = arr.length;
		int start = 0, end = len-1;

		while(start<=end) {
			int middle = start + (end-start)/2;
			System.out.println("Start: "+start+" - end: "+end+" - middle: "+middle+" & MidValue: "+arr[middle]);			
			
			if(arr[middle]==x) return middle;
			
			if(arr[middle]<x) 
				start = middle+1;
			else 
				end = middle-1;
		}

		return -1;
	}
	
    // Driver method to test above 
    public static void main(String args[]) 
    { 
        BinarySearching ob = new BinarySearching(); 
//        int arr[] = { 99, 5, 39, 1, 49, 13, 87, 34, 23 }; 
        int arr[] = { 1, 2, 3, 6, 6, 6, 8, 9, 9 }; 
        int n = arr.length; 
        int x = 6; 
        
        Arrays.sort(arr);
        System.out.print("Input Array: ");
        Arrays.stream(arr).forEach(p->System.out.print(p+" "));
        System.out.print(", Array Size: "+arr.length);
        
        int result = ob.binSearch(arr, x); 
        
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } 

}
