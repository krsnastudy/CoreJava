package com.prac.core.jdks.jdk5.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastDemo {
	public static void main(String[] args) {
		Map<String, String> empName = new HashMap<String, String>();
		empName.put("Sam Hanks", "New york");
		empName.put("Will Smith", "LA");
		empName.put("Scarlett", "Chicago");
		Iterator iterator = empName.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(empName.get(iterator.next()));
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			empName.put("Istanbul", "Turkey");
		}
	}
}

/*

The Fail fast iterator aborts the operation as soon it exposes failures and stops the entire operation. 
Comparatively, Fail Safe iterator doesn't abort the operation in case of a failure. 
Instead, it tries to avoid failures as much as possible.

The Fail Fast iterator throws a ConcurrentModificationException if a collection is modified while iterating over it.
The Fail Fast iterator uses an original collection to traverse over the collection's elements.
They are memory savers, don't require extra memory.
The Fail Fast iterators returned by ArrayList, HashMap, Vector classes.
*/