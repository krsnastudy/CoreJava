package com.prac.core.problem;

public class ArrayPlay {

	public static void main(String[] args) {
		String str1="madamimadam";
		
		for(int i=0;i<str1.length();i++) {
			String str = str1.substring(i, str1.length());
			//System.out.println("String: "+str1+" -- "+i+" -- "+str);
			if(str.length()>2) {
				for(int j=0;j<str.length();j++) {
					//System.out.println("SubString: "+str);
					System.out.print(str.replaceFirst(String.valueOf(str.charAt(j)), "")+" ");
				}				
			}
			System.out.println();
		}
	}
}


// Week -- map 4, set(pallindromstrings)
// eek wek wek wee -- 3, set(pallindromstrings)
// ek ek ee  -- 2, set(pallindromstrings)