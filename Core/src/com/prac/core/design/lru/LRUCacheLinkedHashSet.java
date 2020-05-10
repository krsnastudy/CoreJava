package com.prac.core.design.lru;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCacheLinkedHashSet {

	static Set<Integer> cache;
	int capacity;
	
	public LRUCacheLinkedHashSet(int capacity){
		cache = new LinkedHashSet<Integer>();
		this.capacity=capacity;
	}
	
	  public void put(int key){
	        // If already present, then   remove it first. Note that , we are going to add later 
	        if (cache.contains(key))  
	            cache.remove(key); 
	        // If cache size is full, remove the least , recently used. 
	        else if (cache.size() == capacity) { 
	            int firstKey = cache.iterator().next(); 
	            cache.remove(firstKey); 
	        } 
	        cache.add(key); 
	        
	        System.out.print("Added "+key+" --> Cache: ");
	        display();
	    }
	  
	  // display contents of cache 
	    public void display(){
	        Iterator<Integer> itr = cache.iterator(); 
	        while (itr.hasNext()) { 
	            System.out.print(itr.next() + " "); 
	        }
	        System.out.println();
	    } 

	    public static void print() {
	    	System.out.println("Test");
	    	cache.forEach(System.out::print);
	    }
	    
	public static void main(String[] args) {
		LRUCacheLinkedHashSet ca = new LRUCacheLinkedHashSet(3); 
		 	ca.put(1); 
	        ca.put(2); 
	        ca.put(3); 
	        ca.put(1); 
	        ca.put(4); 
	        ca.put(5);
//	        System.out.print("Final Cache: ");
//            ca.display(); 
	}
}