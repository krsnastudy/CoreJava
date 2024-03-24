package com.prac.core.practice;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPractice {

	public static void main(String[] args) {

		System.out.println("Print Non-Repeated First Character");
		String str = "zzzzzbbbccccddehhhhiii";

		str.chars().mapToObj(m->Character.valueOf((char)m))
			.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
			.entrySet().stream()
			.filter(f->f.getValue()==1L)
			.findFirst().get().getKey();
		
	}

}
