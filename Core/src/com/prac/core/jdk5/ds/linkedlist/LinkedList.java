package com.prac.core.jdk5.ds.linkedlist;

import java.util.HashSet;

public class LinkedList {
	Node head;
	public static final String LINKEDLIST_EMPTY = "Linked List is Empty";

	public boolean isEmpty() {
		return (head == null);
	}

	public Node createNode(int data) {
		Node new_node = new Node(data);
		new_node.next = null;
		return new_node;
	}

	public void insert(LinkedList list, int data) {

		// Create a new node with the give data
		Node new_node = createNode(data);

		if (isEmpty()) {
			head = new_node;
		} else {
			Node last = getLastNode(list);
			last.next = new_node;
		}

	}

	public void insertAt(LinkedList list, int index, int data) {
		Node new_node = createNode(data);
	}

	public void insertFirst(LinkedList list, int data) {
		Node new_node = createNode(data);
		new_node.next = list.head;
		list.head = new_node;
	}

	public void insertLast(LinkedList list, int data) {
		Node newNode = createNode(data);
		Node last = getLastNode(list);
		last.next = newNode;
	}

	public void print(LinkedList list) {

		if (isEmpty()) {
			System.out.print(LINKEDLIST_EMPTY);
		} else {
			System.out.print("LinkedList: ");
			Node current = list.head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
		}
		System.out.println("\n");
	}

	public void print(LinkedList list, String message) {

		if (isEmpty()) {
			System.out.print(LINKEDLIST_EMPTY);
		} else {
			System.out.print(message + ": ");
			Node current = list.head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
		}
		System.out.println();
	}

	public void delete(LinkedList list, int data) {
		Node current = list.head, prev = null;

		// CASE 1: If head node itself holds the key to be deleted
		if (current.next != null && current.data == data) {
			list.head = current.next;
		}

		// CASE 2: If the key is somewhere other than at head
		while (current.next != null && current.data != data) {
			prev = current;
			current = current.next;
		}

		if (current != null) {
			prev.next = current.next;
		} else {
			System.out.println(data + "Not Found");
		}
	}

	public void deleteAt(LinkedList list, int index) {
		int idx = 1;
		Node current = list.head, prev = null;

		while (current.next != null) {
			if (idx == index) {
				prev.next = current.next;
				break;
			} else {
				idx++;
				prev = current;
				current = current.next;
			}
		}
	}

	public void deleteFirst(LinkedList list) {
		Node current = list.head;
		head = head.next;
	}

	public void deleteLast(LinkedList list) {
		Node head = list.head;
		Node tail = getLastNode(list);

		if (isEmpty()) {
			System.out.println(LINKEDLIST_EMPTY);
		} else {
			if (head == tail) {
				list.head = null;
			} else {
				Node current = list.head;
				while (current.next != tail) {
					current = current.next;
				}
				tail = current;
				tail.next = null;
			} // head==tail
		} // isEmpty Else
	}

	public void findLoop() {

	}

	public LinkedList getUnion(LinkedList list1, LinkedList list2) {
		LinkedList unionList = new LinkedList();
//		unionList = list1; /* Not Working copying all values */

		Node firstList = list1.head;
		Node secondList = list2.head;

		while (firstList != null) {
			unionList.insert(unionList, firstList.data);
			firstList = firstList.next;
		}

		while (secondList != null) {
			if (!isPresent(unionList, secondList.data)) {
				unionList.insert(unionList, secondList.data);
			}
			secondList = secondList.next;
		}

		return unionList;
	}

	public LinkedList getIntersection(LinkedList list1, LinkedList list2) {
		LinkedList intersectionList = new LinkedList();
		Node current = list1.head;

		while (current != null) {
			if (isPresent(list2, current.data)) {
				intersectionList.insert(intersectionList, current.data);
			}
			current = current.next;
		}

		return intersectionList;
	}

	public LinkedList reverse(LinkedList list) {
		LinkedList tempList = new LinkedList();
		tempList = copyList(list);

		Node current = tempList.head;
		Node prev = null, next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		tempList.head = prev;

		return tempList;
	}

	public LinkedList copyList(LinkedList list) {
		LinkedList copyList = new LinkedList();
		Node firstList = list.head;

		while (firstList != null) {
			copyList.insert(copyList, firstList.data);
			firstList = firstList.next;
		}
		return copyList;
	}

	public boolean isPresent(LinkedList list, int data) {
		boolean present = false;

		if (list != null) {
			Node current = list.head;

			while (current != null) {
				if (data == current.data) {
					present = true;
					break;
				} else {
					current = current.next;
				}
			}

		}

		return present;
	}

	public int findLength(LinkedList list) {
		Node current = list.head;
		int length = 1;

		if (!isEmpty()) {
			while (current.next != null) {
				length++;
				current = current.next;
			}
		} else {
			length = 0;
		}

		return length;
	}

	public Node getLastNode(LinkedList list) {
		Node last = list.head;

		while (last.next != null) {
			last = last.next;
		}
		return last;
	}

	public void printNode(Node d) {
		System.out.println(d);
	}

	public void bubbleSort(LinkedList list) {
		Node current = list.head;
		int temp;
		Node index = null;

		if (isEmpty()) {
		} else {
			while (current.next != null) {
				index = current.next;

				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				} // inner loop

				current = current.next;
			} // out loop
		} // else
	}// bubbleSort

	public boolean detectLoopUsingHashing(Node h) {
		HashSet<Node> s = new HashSet<Node>();

		while (h != null) {
			if (s.contains(h))
				return true;

			s.add(h);
			h = h.next;
		}

		return false;
	}

}// LinkedList
