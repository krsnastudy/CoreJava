package com.prac.core.jdk5.ds.ll;

import java.util.Arrays;
import java.util.Random;

public class FindLoop {
	Node head;
	
	public static void main(String[] args) {

		CustomLinkedList list1 = new CustomLinkedList();
		CustomLinkedList list2 = new CustomLinkedList();
		
		list1.addElements(list1, 13);
//		System.out.println("Size: "+list1.getSize(list1));
		list1.print("ListOne", list1, true);
		list1.addElements(list2, 9);
		System.out.println();
//		System.out.println("Second List Size: "+list2.getSize(list2));
		list1.print("ListTwo", list2, true);
		
		int l1Size = list1.getSize(list1);
		int l2Size = list2.getSize(list2);
		
		System.out.println("");
		
		int min = Arrays.asList(l1Size, l2Size).stream().mapToInt(i->i).min().getAsInt();
		int randomIndex = new Random().nextInt(1, min);
		System.out.println("\nList1 Size: "+l1Size+" && List2 Size: "+l2Size+" RandomIndex: "+randomIndex);
	
		int addValue = new Random().nextInt(100, 10000);
		
		list1.addElementByIndex(list1, randomIndex, addValue);
		list1.print("\nNew List1", list1, true);
		
		list2.addElementByIndex(list2, randomIndex, addValue);
		list2.print("\nNew List2", list2, true);
		
		System.out.println();
//		System.out.println("\nList1 randomIndex "+list1.getIndexOfElement(list1, randomIndex));
//		System.out.println("List2 randomIndex "+list2.getIndexOfElement(list1, randomIndex));
	
		list1.findCommonElement(list1, list2);
	}

}
