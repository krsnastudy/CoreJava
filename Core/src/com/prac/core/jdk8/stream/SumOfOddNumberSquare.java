package com.prac.core.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfOddNumberSquare {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<>();
		int k=4;
		
		for(int i=1; i<15; i++) {
			aList.add(i);
		}
		
//		List<Integer> oddList =
		int res =
						aList.stream()
							 .filter(i->i%2 ==1)
							 .collect(Collectors.toList())
							 .stream()
							 .map(x->x*x)
							 .reduce(0, Integer::sum)
							 ;
		
//		oddList.forEach(x->System.out.print(x+" "));
		
		System.out.println("Square: "+res);
//		System.out.println(aList);
		
		check(aList, k);
	}
	
	public static void check(List<Integer> aList, int diff) {
//		System.out.println(aList + "  "+diff);
		
		for(int i=0; i<aList.size();i++) {
//			System.out.println(i+ " Iteration : "+aList.get(i));
			for(int j=i+1; j<aList.size(); j++) {
//				System.out.println(i+ " Iteration : "+aList.get(j));
				if((((aList.get(j)-aList.get(i))==diff))||(((aList.get(i)-aList.get(j))==diff))) {
					System.out.print ("("+i+","+j+"), ");
				}
			}
		}
		
		
	}

}
