package com.prac.core.jdk5.iterator;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class FailSafeDemo {
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {

		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 7, 9, 11 });
		Iterator itr = list.iterator();
		System.out.print("Iterator: ");
		while (itr.hasNext()) {
			Integer i = (Integer) itr.next();
			System.out.print(i + " ");
			if (i == 7)
				list.add(15); // It will not be printed
			// This means it has created a separate copy of the collection
		} // while

		System.out.println("\nFinal : " + list);
	}
}

/*

https://www.javatpoint.com/fail-fast-and-fail-safe-iterator-in-java

We can perform the modification operations on a collection while iterating over it.
They will not throw ConcurrentModificationException during the iteration.
The Fail Safe iterators use a copy of the collection to traverse over the elements.
Unlike the Fail Fast, they require more memory as they cloned the collection.
The examples of Fail Safe iterators are ConcurrentHashMap, CopyOnWriteArrayList, etc.

*/