package com.prac.core.jdk5.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddEvenFromArray {

	public static void main(String[] args) {

		int arr [] = new int[] {2,3,7,6,0,9,16,15};
		
		List<Integer> evenList = new ArrayList<>();
		List<Integer> oddList = new ArrayList<>();
		
		Arrays.stream(arr).boxed().forEach(e->{
			if(e%2==0) {
				evenList.add(e);
			}else {
				oddList.add(e);
			}
		});
	
		System.out.println("Given List: "+Arrays.toString(arr));
		System.out.println(" Even List: "+evenList);
		System.out.println("  Odd List: "+oddList);
	}
}