package com.prac.core.jdks.jdk5.ds.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList unionList = new LinkedList();
		LinkedList intersectionList = new LinkedList();
		LinkedList reverseList1 = new LinkedList();
		LinkedList reverseList2 = new LinkedList();

		list1.insert(list1, 275);
		list1.insert(list1, 87);
		list1.insert(list1, 06);
		list1.insert(list1, 91);
		list1.insert(list1, 11);
		list1.insert(list1, 260);
		list1.insert(list1, 135);
		list1.insert(list1, 164);
		list1.insert(list1, 109);
		list1.insert(list1, 545);
		list1.insert(list1, 99);
		list1.print(list1, "Actual First List");
		list1.bubbleSort(list1);
//		list1.print(list1);
		list1.print(list1, "Sorted First List");

		System.out.println();

		list2.insert(list2, 99);
		list2.insert(list2, 26);
		list2.insert(list2, 135);
		list2.insert(list2, 11);
		list2.insert(list2, 999);
		list2.insert(list2, 49);
		list2.insert(list2, 299);
		list2.print(list2, "Actual Second List");
		list2.bubbleSort(list2);
//		list2.print(list2);
		list2.print(list2, "Sorted Second List");

		System.out.println();

		unionList = unionList.getUnion(list1, list2);
		unionList.bubbleSort(unionList);
		unionList.print(unionList, "Union List");

		intersectionList = intersectionList.getIntersection(list1, list2);
		intersectionList.print(intersectionList, "Intersection List");

		reverseList1 = list1.reverse(list1);
		reverseList1.print(reverseList1, "\nReverse List1");

		reverseList2 = list2.reverse(list2);
		reverseList2.print(reverseList2, "Reverse List2");

		LinkedList llist = new LinkedList();

		llist.insert(llist, 20);
		llist.insert(llist, 4);
		llist.insert(llist, 99);
		llist.insert(llist, 652);
		llist.insert(llist, 999);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		if (llist.detectLoopUsingHashing(llist.head))
			System.out.println("Loop Found");
		else
			System.out.println("No Loop Found");

		/*
		 * for (int i = 0; i < 10; i++) { list1.insert(list1,
		 * ((int)(Math.random()*299))); list2.insert(list2, ((int)(Math.random()*699)));
		 * }
		 * 
		 * list1.print(list1); list1.bubbleSort(list1); list1.print(list1);
		 * 
		 * list2.print(list2); list2.bubbleSort(list2); list2.print(list2);
		 */
	}

}

/*
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/ Solution 1:
 * Hashing Approach:
 * 
 * 
 * 
 */