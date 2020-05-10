package com.prac.core.set;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<Integer> ts1 = new TreeSet<Integer>(new MyCompartor()); 
		
        // Elements are added using add() method 
        ts1.add(new Integer(90)); 
        ts1.add(new Integer(80));
        ts1.add(new Integer(40));
  
        // Duplicates will not get insert 
        ts1.add(new Integer(60));
        ts1.add(new Integer(10));
        // Elements get stored in default natural 
        // Sorting Order(Ascending) 
        
        System.out.println(ts1); 
        
	}

}
