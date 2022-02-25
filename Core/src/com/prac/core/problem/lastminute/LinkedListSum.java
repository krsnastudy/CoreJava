package com.prac.core.problem.lastminute;

import java.util.LinkedList;

public class LinkedListSum {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(654);
		list1.add(12);
		list1.add(32);
		list1.add(7);
		list1.add(9);
		list1.add(45);
		list1.add(89);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(7);
		list2.add(6);
		list2.add(1);
		list2.add(162);
		list2.add(475);
		list2.add(96);

		System.out.println("List1: " + list1);
		System.out.println("List2: " + list2);

		int sum = getSum(list1) + getSum(list2);
		System.out.println("\nFinal Sum: " + sum);
	}

	public static Integer getSum(LinkedList<Integer> list) {
		int unit = 1;
		int sum = 0;

		System.out.println("\nList Size: " + list.size());
		for (int i = list.size() - 1; i >= 0; i--) {
			int calc = (list.get(i) * unit);
//			sum = sum + (list.get(i) * unit);
			sum = sum + calc;
			System.out
					.println("List[" + ((list.size() - 1) - i) + "] --> " + list.get(i) + " * " + unit + " = " + calc);
			unit = unit * 10;
		}
//		System.out.println("List Sum: " + sum);
		return sum;
	}
}

/*
 * Java Program: input - 2 linkedlists list1 = 3->1->2 list2 = 6->4->1
 * 
 * output -> Final sum of two lists output list1 sum = (3*100)+(1*10)+(2*1) =
 * 312 list2 sum = (6*100)+(4*10)+(1*1) = 641 FinalSum = 312 + 641;
 * 
 */