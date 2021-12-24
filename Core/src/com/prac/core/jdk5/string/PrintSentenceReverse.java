package com.prac.core.jdk5.string;

public class PrintSentenceReverse {

	public static void main(String[] args) {
		String str = "TreeSet uses compare() or compareTo() methods to compare the elements and thus removing the possible duplicate elements.";
		String[] sArray = str.split(" ");

		System.out.println("Given : " + str);
		System.out.print("Output: ");
		for (int i = (sArray.length - 1); i >= 0; i--) {
			System.out.print(sArray[i] + " ");
		}
	}

}

/*
 * 
 * Given : I am an Indian output: Indian an am I
 * 
 */