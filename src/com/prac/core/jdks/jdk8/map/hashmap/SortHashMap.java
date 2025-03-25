package com.prac.core.jdks.jdk8.map.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMap {

	public static void main(String[] args) {
		 Map<String, Integer> unsortMap = new HashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        unsortMap.put("d", 1);
	        unsortMap.put("e", 7);
	        unsortMap.put("y", 8);
	        unsortMap.put("n", 99);
	        unsortMap.put("g", 50);
	        unsortMap.put("m", 2);
	        unsortMap.put("f", 9);
	        
	        System.out.println("Given Map");
	        unsortMap.entrySet().forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
		
	    
	        //Sort By Key
	        System.out.println("\nSort byKey");
	        unsortMap.entrySet().stream()
	        	.sorted(Map.Entry.comparingByKey())
	        	.forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
	        
	        // Sort By Value
	        System.out.println("\nSort byValue");
	        	unsortMap.entrySet().stream()
	        		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	        		.forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
	        		;
	        		
	        		//Sort By Key
	    	        System.out.println("\nSort byKey Using LinkedHashMap");	        		
//	        Map<String, Integer> lhm = 
	        		unsortMap.entrySet().stream()
	        			.sorted(Map.Entry.comparingByKey())
	        			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n)->o, LinkedHashMap::new))
	        			.forEach((x,y)->System.out.println(x+" "+y));
	        		;
	}//psvm
}//Test
