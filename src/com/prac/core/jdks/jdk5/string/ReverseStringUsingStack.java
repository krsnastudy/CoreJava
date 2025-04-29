package com.prac.core.jdks.jdk5.string;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static void main(String[] args) {
        String input = "Krishna";
        Stack<Character> stack = new Stack<>();
        System.out.println("Given String:"+input);
        pushToStack(input, 0, stack);
        System.out.print("Reversed String:");
        popAndPrint(stack);
    }

    // Recursively push characters into stack
    private static void pushToStack(String input, int index, Stack<Character> stack) {
        if (index == input.length()) {
            return;
        }
        stack.push(input.charAt(index));
        pushToStack(input, index + 1, stack);
    }

    // Recursively pop characters and print
    private static void popAndPrint(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.print(stack.pop());
        popAndPrint(stack);
    }
}
