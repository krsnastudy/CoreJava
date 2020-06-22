package com.prac.core.arrlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDuplicates {
    public static void main(String[] args) {
     
    	List<String> org = new ArrayList<>();
    	List<String> res = new ArrayList<>();
    	
    	org.add("A");
    	org.add("B");
    	org.add("E");
    	org.add("A");
    	org.add("B");
    	org.add("C");
    	org.add("D");
    	org.add("E");
    
    	System.out.print("Original List: "+org);
    	
    	res = org.stream().distinct()
    			.filter(e->Collections.frequency(org, e)>1)
    			.collect(Collectors.toList());
    	System.out.println("\nList of Duplicate Values: "+res);
    	
    	res = org.stream().distinct()
    			.filter(e->Collections.frequency(org, e)==1)
    			.collect(Collectors.toList());    	
    	System.out.println("List with Only occurance Once: "+res);
    	
    	res = org.stream().distinct().collect(Collectors.toList());
    	System.out.println("List without Duplicates: "+res);
    	
    	List<String> list1 = new ArrayList<>();
    	list1.add("M1");
    	list1.add("M2");
    	list1.add("M2");
    	list1.add("M4");
    	list1.add("M11");
    	
    	boolean flag = list1.stream().anyMatch(n -> n.equals("M1"));
    	System.out.println("flag: "+flag);
    	
    	List<String> list = Arrays.asList("M1", "M2", "M3", "M4");
    	   String string = "M11";
    	   boolean match = list.stream().anyMatch(string::contains);
    	   System.out.println("match: "+match);
  }
}