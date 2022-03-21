package com.prac.core.jdk5.ds.linkedlist;

public class LinkedListFindMiddle {

	Node head;

	static class Node {
		// connect each node to next node
		Node next;
		int value;

		Node(int d) {
			value = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		// create an object of LinkedList
		LinkedListFindMiddle linkedList = new LinkedListFindMiddle();

		// assign values to each linked list node
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		linkedList.head = first;

		// connect each node of linked list to next node
		first.next = second;
		second.next = third;
		third.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		// print the linked list
		Node pointer = linkedList.head;
		System.out.print("LinkedList: ");
		while (pointer != null) {
			System.out.print(pointer.value + " ");
			pointer = pointer.next;
		}

		// Find the middle element
		Node ptr1 = linkedList.head;
		Node ptr2 = linkedList.head;

		while (ptr1.next != null) {
			ptr1 = ptr1.next;

			if (ptr1.next != null) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
		} // while loop;

		System.out.println("\nMiddle Element: " + ptr2.value);

	}
}
