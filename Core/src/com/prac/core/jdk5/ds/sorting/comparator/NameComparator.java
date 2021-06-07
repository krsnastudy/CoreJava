package com.prac.core.jdk5.ds.sorting.comparator;

import java.util.*;

class NameComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}