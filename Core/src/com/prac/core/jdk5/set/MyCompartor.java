package com.prac.core.jdk5.set;

import java.util.Comparator;

public class MyCompartor implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// return o2.compareTo(o1);
		return o2 - o1;
	}
}
