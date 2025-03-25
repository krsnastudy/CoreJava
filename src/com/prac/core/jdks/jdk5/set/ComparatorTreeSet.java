package com.prac.core.jdks.jdk5.set;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorTreeSet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		TreeSet ts = new TreeSet(new MyComparator1());
		ts.add(90);
		ts.add(80);
		ts.add(40);
		ts.add(60);
		ts.add(10);
		ts.add(80);

		System.out.println(ts);
	}
}

@SuppressWarnings("rawtypes")
class MyComparator1 implements Comparator {

	public int compare(Object obj1, Object obj2) {

		Integer I1 = (Integer) obj1;
		Integer I2 = (Integer) obj2;

		// + ve means obj1 has to come after(right) obj2
		// - ve means obj1 has to come before(left) obj2

		if (I1 < I2)
			return +1;
		else if (I1 > I2)
			return -1;
		else
			return 0;
	}
}
