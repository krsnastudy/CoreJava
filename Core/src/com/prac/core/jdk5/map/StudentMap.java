package com.prac.core.jdk5.map;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {

	public static void main(String[] args) {

		Map<String, Student> sMap = new HashMap<>();
		Student s1 = new Student("Student1", 1, "School1", "First", "A");
		Student s2 = new Student("Student2", 2, "School1", "First", "A");
		Student s6 = new Student("Student1", 1, "School1", "First", "A");
		
		System.out.println(s1.hashCode()+" s1 "+System.identityHashCode(s1));
		System.out.println(s6.hashCode()+" s6 "+System.identityHashCode(s6));
		System.out.println("s1.equals(s6): "+s1.equals(s6));
		System.out.println("(s1==s6): "+(s1==s6));
		
		System.out.println();
		sMap.put(s1.getStudentname(),s1);
		sMap.put(s2.getStudentname(),s2);
		sMap.put(s6.getStudentname(),s6);
		
		sMap.forEach((x, y)->System.out.println(x+": "+y.hashCode()));
		System.out.println();
		System.out.println(sMap);
		
		System.out.println("\n/*********************/");
		Map<Student, String> cMap = new HashMap<>();
		Student c1 = new Student("Student1", 1, "School1", "First", "A");
		Student c2 = new Student("Student2", 2, "School1", "First", "A");
		Student c6 = new Student("Student1", 1, "School1", "First", "A");

		System.out.println(c1.hashCode()+" c1 "+System.identityHashCode(c1));
		System.out.println(c6.hashCode()+" c6 "+System.identityHashCode(c6));
		System.out.println("c1.equals(c6): "+c1.equals(c6));
		System.out.println("(c1==c6): "+(c1==c6));
		
		System.out.println();
		cMap.put(c1, c1.getStudentname());
		cMap.put(c2, c2.getStudentname());
		cMap.put(c6, c6.getStudentname());
		System.out.println();
		cMap.forEach((x, y)->System.out.println(x+": "+x.hashCode()));
//		cMap.forEach((x, y)->System.out.println(x));
		System.out.println(cMap);
	}

}

