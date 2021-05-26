package com.prac.core.jdk5.string.permutation;

import java.util.Set;
import java.util.TreeSet;

// Java program to print all permutations using
//Heap's algorithm
public class HeapAlgo{
	
	public static Set<Integer> set = new TreeSet<>();
	
	//Prints the array
	void printArr(int a[], int n){
		String str="";
		for (int i=0; i<n; i++) {
		 str=str + a[i];
		}
		set.add(Integer.parseInt(str));
	}

	//Generating permutation using Heap Algorithm
	void heapPermutation(int a[], int size, int n){
		// if size becomes 1 then prints the obtained
		// permutation 
		if (size == 1)
			printArr(a,n);

		for (int i=0; i<size; i++){
			heapPermutation(a, size-1, n); 

			// if size is odd, swap first and last
			// element
			if (size % 2 == 1){ 
				int temp = a[0]; 
				a[0] = a[size-1]; 
				a[size-1] = temp; 
			} 

			// If size is even, swap ith and last
			// element
			else{ 
				int temp = a[i]; 
				a[i] = a[size-1]; 
				a[size-1] = temp; 
			}
		}
	}

	// Driver code
	public static void main(String args[]){ 
		HeapAlgo obj = new HeapAlgo();
		int number = 0, d=8;
		int a[] = {1,2,3,4,5}; 
		obj.heapPermutation(a, a.length, a.length);
		
		System.out.println("Set Size: "+set.size());
		set.forEach(x->System.out.print(x + " "));
		System.out.println();
		
		for(Integer i : set) {
			//System.out.println(i);
			if((i%d)==0) {
				number = i;
				break;
			}
		}
		
		System.out.format("Smallest number Divided by %s is : %s", d, number);
	}
} 
