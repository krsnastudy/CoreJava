package com.prac.core.jdk8.handson;

import java.util.Arrays;

public class SortBySecondName {

	public static void main(String[] args) {
		String[] sArray = {"Radha, Krishna", "Kalam, Abdul", "Mishra, Gokul", "Mohit, Bansal", "Kapil, Baarat"};
		
		Arrays.asList(sArray)
		.stream()
		.sorted((x,y)->{
			String[] fs = x.split(",");
			String[] ss = y.split(",");
			return fs[1].compareTo(ss[1]);
		})
		.forEach(p->System.out.print("["+p+"], "));
		;
	}

}
