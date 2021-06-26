package com.prac.core.jdk5.ds.ll;

public class LinkedListExample {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int i) {
			data = i;
			next = null;
		}

	}

	public void addItem(LinkedListExample list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node last = list.head;

			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}
	}

	public void printList(LinkedListExample list) {
		Node currNode = list.head;

		if (currNode == null) {
			System.out.println("No Elements");
		} else {
			while (currNode != null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.next;
			}
		}

	}

	public int size(LinkedListExample list) {
		int len=0;
		Node currNode = list.head;

		if (currNode != null) {
			while (currNode != null) {
				currNode = currNode.next;
				len++;
			}
		}
		return len;
	}
	public static void main(String[] args) {

		LinkedListExample list = new LinkedListExample();

		list.addItem(list, 1);
		list.addItem(list, 2);
		list.addItem(list, 3);
		list.addItem(list, 4);
		list.addItem(list, 5);
		list.addItem(list, 6);
		System.out.println("Size of the List: "+list.size(list));
		list.printList(list);
	}

}
