package com.prac.core.jdk5.ds.queue;

import java.util.Arrays;

import com.prac.core.jdk5.classloader.Test;

class Queue {
	private static int front, rear, capacity;
	private static int queue[];

	Queue(int size) {
		this.front = this.rear = 0;
		this.capacity = size;
		this.queue = new int[capacity];
	}

	static void enqueue(int data) {
		if (capacity == rear) {
			System.out.println("Cannot Insert, Queue is Full");
		} else {
			queue[rear] = data;
			rear++;
		}
		return;
	}

	static void dequeue() {
		if (front == rear) {
			System.out.println("Cannot delete, Queue is Empty");
		} else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}

			if (rear < capacity) {
				queue[rear] = 0;
			}
			rear--;
		}
		return;
	}

	static void printQueue() {
		if (front == rear) {
			System.out.println("Queue is Empty");
		} else {
			System.out.println("Queue Elements: " + Arrays.toString(queue));
		}
	}
}

public class QueueImplUsingArray {

	public static void main(String[] args) {
		System.out.println("Loaded By: "+QueueImplUsingArray.class.getClassLoader());
		Queue q = new Queue(5);

		q.printQueue();

		q.enqueue(99);
		q.enqueue(26);
		q.enqueue(35);
		q.printQueue();

		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.printQueue();
	}
}