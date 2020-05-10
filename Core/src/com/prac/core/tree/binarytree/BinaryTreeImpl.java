package com.prac.core.tree.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeImpl {

	public static void main(String[] args) {

		TreeOwn bt = new TreeOwn();
		/*
		bt.add(90);
		bt.add(80);
		bt.add(40);
		bt.add(60);
		bt.add(10);
		bt.add(100);
		bt.add(25);
		bt.add(1);
		bt.add(99);
		bt.add(154);
		bt.add(58);
		bt.add(14);*/
		//System.out.println(bt.getSize());
		//bt.printAllTraversal();
		
		
		Map<Integer, Employee> eMap = new HashMap<>();
		GenerateData data = new GenerateData();
		TreeMap<Integer, Employee> tm = new TreeMap<>();
		
		eMap = data.createEmployee(10);
//		System.out.println(eMap);
		eMap.forEach((k,v)->v.toStringEno(v));
		
//		tm = (TreeMap<Integer, Employee>) eMap; 
		// in thread "main" java.lang.ClassCastException: java.util.HashMap cannot be cast to java.util.TreeMap
		
		System.out.println();
		eMap.forEach((k,v)->tm.put(k, v));

//		System.out.println(tm);
		tm.forEach((k,v)->v.toStringEno(v));
		
	}

}
