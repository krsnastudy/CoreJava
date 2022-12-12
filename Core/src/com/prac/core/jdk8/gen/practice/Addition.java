package com.prac.core.jdk8.gen.practice;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Addition {

	public static void main(String[] args) {
		Set<String> lhs = new LinkedHashSet<>();
		Random random = new Random();
		int range = 100;

		for (int i = 1; i < 1000000; i++) {
			int i1 = random.nextInt(range);
			int i2 = random.nextInt(range);

			String str = "";
			if ((i1 > 9 && i2 > 9) && (i1 != i2)) {
//			if ((i1 > 9 && i2 > 9)) {
				str = i1 + " + " + i2 + " = ";
				lhs.add(str);
			}
			
		}
		
//		System.out.println("Size: "+lhs.size());

		lhs.stream().forEach(x -> System.out.println(x));

	}
}
