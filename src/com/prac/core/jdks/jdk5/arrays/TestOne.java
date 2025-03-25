package com.prac.core.jdks.jdk5.arrays;

public class TestOne {

	public static void main(String[] args) {
		int[] arr = new int[5];
		String[] strArr = new String[5];
		/*
		 * System.out.println("Int Array: "+arr);
		 * System.out.println("Int Array: "+Arrays.toString(arr));
		 * 
		 * System.out.println("\nString Array: "+strArr);
		 * System.out.println("String Array: "+Arrays.toString(strArr));
		 */
		Array array = new Array(3);
		array.insert(1);
		array.insert(2);
		array.insert(3);
		array.insert(4);
		array.insert(5);
		array.insert(6);
		array.print();

		System.out.println();
		array.removeAt(2);
		array.print();

		System.out.println();
		array.removeAt(4);
		array.print();
	}
}
