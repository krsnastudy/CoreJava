package com.prac.core.jdk5.ds.ll;

import java.util.Random;
import java.util.stream.IntStream;

public class CustomLinkedList {
	Node head;

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();

		// assign values to each linked list node
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		list.head = first;
		first.next = second;
		second.next = third;
		third.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		print("Created List", list, true);
		findMiddle(list);
		addElement(list, 8);
		print("Created List", list, true);
		addElements(list, 13);
		print("\nModified List", list, true);
		findMiddle(list);
		System.out.println("\nSize of LinkedList: " + getSize(list));
		deleteElementByKey(list, 7);
		deleteElementByIndex(list, 30);
		print("Modified List", list, true);
		System.out.println("\nSize of LinkedList: " + getSize(list));
		findMiddle(list);
	}

	public static void print(String str, CustomLinkedList ptr, boolean isPrint) {
		// print the linked list
		Node pointer = ptr.head;
		System.out.print(str + ": ");
		while (pointer != null) {
			if (isPrint)
				System.out.print(pointer.data + " ");
			pointer = pointer.next;
		}
	}

	public static void findMiddle(CustomLinkedList list) {

		Node ptr1 = list.head;
		Node ptr2 = list.head;
		int index = 1;
		while (ptr1.next != null) {

			ptr1 = ptr1.next;
			if (ptr1.next != null) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
				index++;
			}
		} // while

		int value = ptr2.data;
		System.out.println("\nMiddle Element: " + value + ", Index(" + value + "): " + index);
	}

	public static void addElement(CustomLinkedList list, int addValue) {

		Node curr = list.head;
		Node new_node = new Node(addValue);

		if(list.head==null) {
			list.head=new_node;
		}else {
			while (curr.next != null) {
				curr = curr.next;
			}
	
			curr.next = new_node;
		}
//		print("Added " + addValue, list, true);
//		findMiddle(list);
	}

	public static void addElements(CustomLinkedList list, int range) {

		IntStream.rangeClosed(0, range).boxed().forEach(i -> {
			CustomLinkedList.addElement(list, new Random().nextInt(100));
		});
	}

	public static void deleteElementByKey(CustomLinkedList list, int key) {
		Node curr = list.head, prev = null;
		boolean isDeleted = false;

		if (curr.next != null && curr.data == key) {
			list.head = curr.next;
			isDeleted = true;
		}

		while (curr.next != null && curr.data != key) {
			prev = curr;
			curr = curr.next;
		}

		if (curr != null) {
			prev.next = curr.next;
			isDeleted = true;
		}

		if (isDeleted) {
			print("Element[" + key + "] Deleted", list, true);
		}
	}

	public static void deleteElementByIndex(CustomLinkedList list, int index) {
		Node curr = list.head, prev=null;
		int idx=1;
		
		if(curr.next!=null && idx==index) {
			list.head=curr.next;
		}
		
		while(curr.next!=null && idx!=index) {
			prev=curr;
			curr = curr.next;
			idx++;
		}
		
		if(curr!=null) {
			prev.next=curr.next;
		}
		
		System.out.println("\nIndex "+index+" Element: "+curr.data+" Deleted\n");
	}
	
	public static int getSize(CustomLinkedList list) {
		int size = 0;
		Node curr = list.head;
		while (curr.next != null) {
			curr = curr.next;
			size++;
		}
		return size;
	}

	public static void addElementByIndex(CustomLinkedList list, int index, int addValue) {
		Node curr = list.head, nextNode=null;
		Node new_node = new Node(addValue);
		int idx=1;
		
		if(curr.next!=null && idx==index) {
			new_node.next=curr;
			list.head=new_node;
		}
		
		while(curr.next!=null && idx!=index) {
//			System.out.println(idx);
			curr = curr.next;
			nextNode = curr.next;
			idx++;
		}
		
		if(curr.next!=null) {
			curr.next=new_node;
			new_node.next=nextNode;
		}
	}
	
	public static void findCommonElement(CustomLinkedList list1, CustomLinkedList list2) {
		Node curr1 = list1.head;
		Node curr2 = list2.head;
		int idx=0; boolean canBreak=false;
		
		while(curr1.next!=null) {
//			System.out.println("Checking List1 : "+curr1.data);
			idx++;
			
			while(curr2.next!=null) {
//				System.out.println("Checking List2 : "+curr1.data+" -- "+curr2.data);
				if(curr2.data==curr1.data) {
					System.out.println("Common Point: "+curr1.data+" Index: "+idx);
//					System.out.println("Checking: "+curr1.data+" "+curr2.data);
					canBreak=true;
					break;
				}else {
					curr2 = curr2.next;
				}
			}
			curr2 = list2.head;
			curr1 = curr1.next;
			if(canBreak) break;
		}
		
//		System.out.println("No Common "+idx);
	}
	
	public static int getIndexOfElement(CustomLinkedList list, int index) {
		Node curr = list.head;
		int idx=0;
		
		if(curr.next==null) {
			return 0;
		}
		
		if(curr.next!=null && idx==index) {
			return list.head.data;
		}
		
		while(curr.next!=null && idx!=index) {
			curr = curr.next;
			idx++;
		}
		
		return curr.data;
	}
}//
