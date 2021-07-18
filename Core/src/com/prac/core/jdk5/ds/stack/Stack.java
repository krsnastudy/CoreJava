package com.prac.core.jdk5.ds.stack;

public interface Stack {
	public abstract void push(int item);
	public abstract int pop();
	public abstract boolean isEmpty();
	public abstract boolean isFull();
	public abstract int peek();
	public void printStackElements();
}


/*
push: Push element to the top of the Stack.This operation will increase size of stack by 1.
pop: Remove element from the top of the Stack and returns the deleleted Object.This operation will decrease size of stack by 1.
isEmpty: Check if Stack is empty or not.
isFull: Check if Stack is full or not.
peek: Returns top element from the stack without removing it.
*/