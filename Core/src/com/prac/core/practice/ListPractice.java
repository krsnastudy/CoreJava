package com.prac.core.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListPractice {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		
		
		random.ints(0, 10).limit(230).forEach(e->list.add(e));
		System.out.println(random.ints(0, 10).limit(23).summaryStatistics());
		
		
		list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())).forEach((x,y)->System.out.println(x+" "+y));
		
		
	}

}
