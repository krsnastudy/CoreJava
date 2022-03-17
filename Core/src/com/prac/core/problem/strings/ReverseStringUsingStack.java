package com.prac.core.problem.strings;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		String str = "India";
        str = reverse(str);        // string is immutable
        System.out.println("The reverse of the given string is: " + str);
	}

	public static String reverse(String str) {
		// create an empty stack of characters
		Stack stack = new Stack(str.length());
		char[] ch = str.toCharArray();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(ch[i]);
		}
		
		int k = 0;
		
		while (!stack.isEmpty())        {
            // assign each popped character back to the character array
            ch[k++] = (char) stack.pop();
        }
		return String.copyValueOf(ch);
	}
}

/*
 * https://www.techiedelight.com/stack-implementation-in-java/
 * https://www.techiedelight.com/10-ways-reverse-a-string-java/
		Using StringBuilder/StringBuffer
		Using Stack
		Using Java Collections Framework reverse() method
		Using character array
		Using character array and swap()
		Using + (string concatenation) operator
		Using Unicode Right-to-left override (RLO) character
		Using a Byte Array
		Using Recursion
		Using substring() method
 * 
 * 
 */