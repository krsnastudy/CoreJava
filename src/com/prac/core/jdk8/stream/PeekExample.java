package com.prac.core.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PeekExample {

	public static void main(String[] args) {

		//Stream.peek() without terminal operation
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		         
		List<Integer> newList = list.stream()
//		            .peek(System.out::println)
		            .peek(x->System.out.print(x+" "))
		            .collect(Collectors.toList());
		
		System.out.println("\n"+newList);
		System.out.println();
		
		List<Integer> li = IntStream.rangeClosed(1, 100)
							.filter(a-> (a%2==0))
//							.filter(a-> ((a/1==a)&&(a/a==1)))
							.mapToObj(i->i)
//							.peek(System.out::print)
							.peek(x->System.out.print(x+" "))
							.collect(Collectors.toList());
		
		System.out.println();
		System.out.println("List: "+li);
		
	}

}


/**
 * 
 * 
 * 
 https://howtodoinjava.com/java8/java-stream-peek-example/\
 * 
 * */
 