package com.prac.core.problem.gen;

import java.util.HashSet;
import java.util.Set;

public class PrintPallindrome {
	
public static Set<String> result = new HashSet<>();

//Java program to print all 
//possible strings of length k 
	
//The method that prints all 
//possible strings of length k. 
//It is mainly a wrapper over 
//recursive function printAllKLengthRec() 
static void printAllKLength(char[] set, int k) 
{ 
	int n = set.length; 
	printAllKLengthRec(set, "", n, k); 
} 

//The main recursive method 
//to print all possible 
//strings of length k 
static void printAllKLengthRec(char[] set, 
							String prefix, 
							int n, int k) 
{ 
	
	// Base case: k is 0, 
	// print prefix 
	if (k == 0){ 
		if(isPalindrome(prefix)) {
			result.add(prefix);
		}
		//System.out.println(prefix); 
		return; 
	} 

	// One by one add all characters 
	// from set and recursively 
	// call for k equals to k-1 
	for(int i=0; i<n; ++i){
		
		// Next character of input added 
		String newPrefix = prefix + set[i]; 
		
		// k is decreased, because 
		// we have added a new character 
		printAllKLengthRec(set, newPrefix, n, k - 1); 
	}
} 

static boolean isPalindrome(String str){ 
	  
    // Pointers pointing to the beginning 
    // and the end of the string 
    int i = 0, j = str.length() - 1; 

    // While there are characters toc compare 
    while (i < j) { 

        // If there is a mismatch 
        if (str.charAt(i) != str.charAt(j)) 
            return false; 

        // Increment first pointer and 
        // decrement the other 
        i++; 
        j--; 
    } 

    // Given string is a palindrome 
    return true; 
} 

//Driver Code 
public static void main(String[] args) 
{ 
	System.out.println("First Test"); 
	char[] set1 = {'a', 'b'}; 
	int k = 3; 
	//printAllKLength(set1, k); 
	
	System.out.println("\nSecond Test"); 
	char[] set2 = {'w', 'e', 'e', 'k'}; 
	k = 3; 
	printAllKLength(set2, k); 
	
	System.out.println(result);
} 
} 
