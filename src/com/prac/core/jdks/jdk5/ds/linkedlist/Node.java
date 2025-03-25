package com.prac.core.jdks.jdk5.ds.linkedlist;

public class Node {

	public int data;
	public Node next;

	Node(int d) {
		this.data = d;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}
