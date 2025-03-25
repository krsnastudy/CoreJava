package com.prac.core.jdks.jdk8.stream.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamArrayListEx {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		int listSize = 14;
		
		Consumer<List<Integer>> print = y -> y.stream().forEach(x->System.out.print(x+" "));
		
		for(int i=0; i<listSize; i++){
			l.add(new Random().nextInt(1000));
		}
		
		/* Sorting */
//		Collections.sort(l);
//		l.stream().sorted((a,b)->-a.compareTo(b)).forEach(x->System.out.print(x+" "));
//		System.out.println();
//		l.stream().sorted((a,b)->b-a).forEach(x->System.out.print(x+" "));
		
		System.out.println("\nPrinting Actual List of Size: "+l.size());
//		l.stream().forEach(x->System.out.print(x+" "));
		print.accept(l);
		
		Long size = l.stream().distinct().count();
//		System.out.println(l.size()+" -- "+size);
		
		List<Integer> even = l.stream()
								.distinct()
								.filter(i->i%2==0)
//								.forEach(x->System.out.print(x+" "));
								.collect(Collectors.toList());
		
		System.out.println("\n\nPrinting Even List of Size: "+even.size());
		print.accept(even);
		
		List<Integer> odd = l.stream()
				             .distinct()
				             .filter(i->i%2!=0)
				             .collect(Collectors.toList());

		System.out.println("\n\nPrinting Odd List of Size: "+odd.size());
		print.accept(odd);
		
		List<Integer> doubleValue = l.stream().distinct()	
							   .map(i->i*2).collect(Collectors.toList());
		
		System.out.println("\n\nPrinting Double of each element in the List of Size: "+doubleValue.size());
		print.accept(doubleValue);
		
		Integer min = l.stream().min((a,b)->a-b).get();
		Integer max = l.stream().max((a,b)->a-b).get();
		System.out.println("\n\nMin & Max Value: "+min+" & "+max);
		
		Integer[] iArray = l.stream().toArray(Integer[]::new);
		System.out.println("\nArrayList to Array: "+Arrays.toString(iArray));
	}						  
}