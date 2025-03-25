package com.prac.core.jdks.jdk5.string;

import java.util.HashSet;

public class StringHasAllUniqueChars {

	public static void main(String[] args) {
		System.out.println("Apple has all unique chars : "+ hasAllUniqueCharsByIndex("apple"));
		System.out.println("index has all unique chars : "+ hasAllUniqueCharsByIndex("repay"));
	}

	//check if String has all unique characters Using HashSet:
	public static boolean hasAllUniqueCharsByHashSet(String word) {
		HashSet<Character> alphaSet = new HashSet<>();
		
		for (int index = 0; index < word.length(); index++) {
			char c = word.charAt(index);
			// If Hashset's add method return false,that means it is already present in HashSet
			if (!alphaSet.add(c))
				return false;
		}

		return true;
	}
	
	//By using indexOf and lastIndexOf methods.
	public static boolean hasAllUniqueCharsByIndex (String word) {
		 
	     for(int index=0;index < word.length(); index ++)   {
	 
	         char c =word.charAt(index);
	         if(word.indexOf(c)!=word.lastIndexOf(c))
	              return false;
	     }
	 
	     return true;
	 }
	
	//By using ascii value of character
	public static boolean hasAllUniqueCharsByASCII(String word) {
	     boolean[] charMap = new boolean[26];
	 
	     for(int index=0;index < word.length(); index ++)   {
	      // we are substracting char's ascii value to 64, so we get all index from 0 to 25.
	         int asciiCode = (int) word.toUpperCase().charAt(index) - 64;
	 
	         // If char is not present, it should have false at that index
	         if(!charMap[asciiCode])
	        	 charMap[asciiCode] = true;
	          else
	             return false;
	     }
	 
	     return true;
	 }
	
}// StringHasAllUniqueChars



/*

https://java2blog.com/check-if-string-has-all-unique-characters-in-java/#By_using_indexOf_and_lastIndexOf_methods

*/