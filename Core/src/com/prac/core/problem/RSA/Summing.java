package com.prac.core.problem.RSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Summing {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		
		arr.add(0);
		arr.add(0);
		arr.add(0);
		arr.add(0);
		arr.add(0);
		
		arr.add(1);
		arr.add(1);
		arr.add(1);
		arr.add(1);

	
		int sume = arr.stream().filter(i->i==0).collect(Collectors.summingInt(Integer::intValue));
		arr.stream().filter(i->i==0).reduce(0, Integer::sum);
		
		Map<Integer, Integer> map = arr.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(Integer::intValue)));
		Map<Integer, List<Integer>> list = arr.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.toList()));

		System.out.println(map);
		System.out.println(list);

	}

}
