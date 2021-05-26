package com.prac.core.problem.gen;

import java.util.ArrayList;
import java.util.List;

public class FibonacciEvenAdd {

	public static void main(String[] args) {

		int fibonacci=1;
		int limit = 8;
		int prev=fibonacci;
		List<Integer> fList = new ArrayList<>();
		
		while(fibonacci<limit) {
			fibonacci = fibonacci+prev;
			prev = fibonacci;
			fList.add(fibonacci);
		}
		
		System.out.println(fList);
	}

}
