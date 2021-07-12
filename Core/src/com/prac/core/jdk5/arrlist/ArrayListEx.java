package com.prac.core.jdk5.arrlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> str= new ArrayList<String>();
		// Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 0
		//str.add(5,"sbc");
		str.add(new Integer(1).toString());
//		System.out.println(str);
		
		int size=25; int index = 5;
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<size; i++) {
			list.add(new Random().nextInt(5000));
		}
		
		System.out.println("List Size: "+list.size()+"\n");
		System.out.println("UnSorted: "+list);
		list.sort(null);
		System.out.println("  Sorted: "+list);
		
		System.out.println();
		System.out.println(index +" Highest Number: "+list.get(index-1));
		System.out.println("Highest Number: "+list.get(list.size()-1));
		
		System.out.println();
		System.out.println("Even Numbers");
		list.stream().filter(x->x%2==0).forEach(x->System.out.print(x+" "));
		System.out.println();
		System.out.println("\nOdd Numbers");
		list.stream().filter(x->x%2!=0).forEach(x->System.out.print(x+" "));
		
		System.out.println("\n\nNew ArrayList Size");
		ArrayList<String> arr = new ArrayList<String>(5);
		System.out.println(arr.size());
		arr.add(0, "Zero");
		arr.add(1, "One");
		arr.add(3, "Three");
		System.out.println("List: "+arr);
	}

}
