package com.prac.core.problem.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortSecondString {

	public static void main(String[] args) {
		String[] input = {"Sachin Sree","Ram Atluri","Krishna CVR","Jhon Ac"};
		
		System.out.println("Input:  "+Arrays.asList(input));
		
		List<String> aList = Arrays.stream(input).sorted((a, b)->{
			String[] fs = a.split(" ");
	        String[] ss = b.split(" ");
	        // you should ensure that there are actually two elements here
	        return fs[1].compareTo(ss[1]);
			
		}).collect(Collectors.toList());
		
		System.out.println("Output: "+aList);
	}

}

/*
Input:  {"Sachin sree","ram ab","kish c","jhon ac"}
Output: {"ram ab","jhon ac","kish c","Sachin sree"}

Sort the Array based on the second String

https://stackoverflow.com/questions/15210748/how-to-sort-an-array-of-strings-alphabetically-by-second-word-in-java

class SecondWordComparator implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2)
    {
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");

        // you should ensure that there are actually two elements here
        return a1[1].compareTo(a2[1]);
    }
}
*/