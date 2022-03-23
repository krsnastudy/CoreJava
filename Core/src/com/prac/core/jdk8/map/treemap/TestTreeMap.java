package com.prac.core.jdk8.map.treemap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TestTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> t = new TreeMap<>();
		List<Integer> l = new ArrayList<>();
		
		l.add(17);
		l.add(1);
		l.add(3);
		l.add(5);
		l.add(10);
		l.add(9);
		l.add(12);
		l.add(0);
		l.add(20);
		System.out.print("         List Insertion Order ==> ");
		l.forEach(x->System.out.print(x+" "));
		Collections.sort(l);
		
		System.out.print("\n   List Sorting Natural Order ==> ");
		l.forEach(x->System.out.print(x+" "));
		
		
//		Collections.sort(l, ((a,b)->(a<b)?1:(a>b)?-1:0));
		Collections.sort(l, ((a,b)->(b-a)));
		System.out.print("\nList Sorting Descending Order ==> ");
		l.forEach(x->System.out.print(x+" "));

		System.out.println("\n\n<*****Map*****>");
		t.put(19, "NineTeen");
		t.put(1, "One");
		t.put(29, "TwentyNine");
		t.put(10, "Ten");
		t.put(1, "One");
		t.put(39, "ThirtyNine");
		t.put(20, "Twenty");
		t.put(5, "Five");
		t.put(55, "FiftyFive");
		
		t.entrySet().forEach(x->System.out.print(x.getKey()+" "));
//		Collections.checkedSortedMap(t, ((a,b)->(a<b)?1:(a>b)?-1:0));
		
	}

}
