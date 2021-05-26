package com.prac.core.jdk5.ds.sorting;

public class InsertionSorting {

	public static void main(String[] args) {
		int arr[] = { 90, 80, 40, 60, 10  };
		System.out.println("Array Size: "+arr.length);
		System.out.print("UnSorted Array: ");
		printArray(arr);
		
		InsertionSorting ob = new InsertionSorting(); 
		ob.sort(arr); 
		
		System.out.print("\nFinally Sorted Array: ");
		printArray(arr); 
	}
	
	void sort(int arr[]){ 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) {
			
			int key = arr[i]; 
			int j = i - 1; 
			//System.out.println("i: "+i+"; Key: "+key+"; j: "+j);
			/* Move elements of arr[0..i-1], that are 
			greater than key, to one position ahead 
			of their current position */
			System.out.println();
			System.out.print("Before Iterartion["+i+"] Array ") ;
			printArray(arr);
			System.out.println("Iterartion["+i+"] Process Internally") ;
			
			while (j >= 0 && arr[j] > key) { 
				System.out.print("Internal Loop["+j+"]: ") ;
				arr[j + 1] = arr[j]; 
				j = j - 1; 
				printArray(arr);
			} 
			arr[j + 1] = key; 
			//System.out.println();
			System.out.print("Iterartion["+i+"] Sorted Array: ") ;
			printArray(arr);
		} 
	} 
	
	/* A utility function to print array of size n*/
	public static void printArray(int arr[]){ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " "); 
		}
		
//	  Stream.of(arr).forEach(x->System.out.println(x));
//		Stream.of(arr).forEach(System.out::print);
		System.out.println(); 
	} 

}
