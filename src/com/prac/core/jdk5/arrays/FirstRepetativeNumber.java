package com.prac.core.jdk5.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstRepetativeNumber {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 7, 2, 1, 6, 8, 1 };
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.merge(arr[i], 1, Integer::sum);
		}

		System.out.println(map.entrySet().stream().filter(i -> i.getValue() > 0).findFirst().get());
		
		System.out.println(Arrays.stream(arr).average());
		System.out.println(Arrays.stream(arr).sum());
		
		System.out.println(IntStream.rangeClosed(1, 100).limit(50).filter(i->i%2==0).count());
		System.out.println(Stream.iterate(0, n->n+1).limit(100).filter(f->f%2==1).collect(Collectors.toList()).stream().map(s->s+"").collect(Collectors.joining(", ")));
		
			
	}

}
