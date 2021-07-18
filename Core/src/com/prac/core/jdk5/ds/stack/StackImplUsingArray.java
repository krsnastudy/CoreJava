package com.prac.core.jdk5.ds.stack;

import java.util.Arrays;

public class StackImplUsingArray implements Stack {

	int size;
	int arr[];
	int top;

	StackImplUsingArray(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}

	@Override
	public void push(int element) {
		if (isFull()) {
			System.out.println("Cannot Push, Stack is Full");
		} else {
			top++;
			arr[top] = element;
			System.out.println("Pushed Element:" + element);
		}
	}

	@Override
	public int pop() {

		if (isEmpty()) {
			System.out.println("Cannot Pop, Stack is Empty");
			return -1;
		} else {
			int returnedTop = top;
			top--;
			System.out.println("Popped Element :" + arr[returnedTop]);
			return arr[returnedTop];
		}
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		return (size - 1 == top);
	}

	@Override
	public int peek() {

		if (!isEmpty()) {
			System.out.println("Stack Peek: " + arr[top]);
			return arr[top];
		} else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}

	@Override
	public void printStackElements() {
		System.out.println("Stack Elements: " + Arrays.toString(arr));
	}

	public static void main(String[] args) {

		StackImplUsingArray stackImplUsingArray = new StackImplUsingArray(10);

		stackImplUsingArray.pop();

		System.out.println("=================");
		stackImplUsingArray.push(10);
		stackImplUsingArray.push(20);
		stackImplUsingArray.push(30);
		stackImplUsingArray.push(40);
		stackImplUsingArray.push(50);
		stackImplUsingArray.peek();
		stackImplUsingArray.push(60);

		System.out.println("=================");
		stackImplUsingArray.pop();
		stackImplUsingArray.peek();
		stackImplUsingArray.pop();
		stackImplUsingArray.pop();
		stackImplUsingArray.pop();
		stackImplUsingArray.pop();

		System.out.println("=================");
		stackImplUsingArray.peek();

		System.out.println("=================");
		stackImplUsingArray.printStackElements();
	}
}