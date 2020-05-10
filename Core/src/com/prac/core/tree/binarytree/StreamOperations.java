package com.prac.core.tree.binarytree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {

		Map<Integer, Employee> eMap = new HashMap<>();
		GenerateData data = new GenerateData();
		
		eMap = data.createEmployee(4);
//		System.out.println(eMap);
		
		/* Print hashMap*/
		System.out.println("Actual Map: ");
//		eMap.forEach((k,v)->System.out.println(k+" = "+v.toString()));
		eMap.forEach((k,v)->System.out.println(k+" = "+v.hashCode()));
		System.out.println();
		
		/* Print Only Duplicates */
		System.out.println("Print Only Duplicates");
		Map<Integer, Employee> pdMap = eMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(OldValue, newValue) -> newValue, LinkedHashMap::new
						));
		
		pdMap.forEach((k,v)->System.out.println(k+" = "+v.toString()));
	}

}
