package com.prac.core.problem.morganstanley;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayProgram {

	public static void main(String[] args) {
		int[] arr = {0,1,0,1,0};
		
	Arrays.stream(arr)
		.boxed()
		.sorted(Comparator.reverseOrder())
		.mapToInt(i -> i)
		.forEach(x->System.out.print(x+" "));
	}
}

/*

Array arr = {0,1,0,1,0};
OP:1,1,0,0,0
What is the time complexity

*/