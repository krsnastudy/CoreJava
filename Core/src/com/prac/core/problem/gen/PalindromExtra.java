package com.prac.core.problem.gen;
// adam mdam maam mdam adam 
import java.util.*;
public class PalindromExtra {
    public static void main(String[] args) {
        //Scanner in=new Scanner(System.in);
        //System.out.println("ENTER A STRING");
        String input="madam";
//        Set<String> se=find(in.nextLine());
		/*
		 * int end = input.length(); for(int i=0;i<end;i++){ Set<String>
		 * se=find(input.substring(i, end)); System.out.println((se)); }
		 */
        
        Set<String> se=find(input);
        System.out.println((se));
    }
    public static Set<String> find(String s){
        Set<String> ss=new HashSet<String>();
        Set<String> hh=new HashSet<String>();
        if(s==null){
            return null;
        }
        if(s.length()==0){
            ss.add("");
        }else{
            char c=s.charAt(0);
            String st=s.substring(1);
            Set<String> qq=find(st);
            for(String str:qq){
                for(int i=0;i<=str.length();i++){
                    ss.add(comb(str,c,i));
//                	if(isPalindrome(comb(str,c,i))){ ss.add(comb(str,c,i)); }
                	String sTemp = comb(str,c,i);
//                	System.out.println(sTemp);
                	if(isPalindrome(sTemp)) {hh.add(sTemp);}
                }
            }
        }
        System.out.println(hh);
        return ss;
    }
    
    public static String comb(String s,char c,int i){
        String start=s.substring(0,i);
        String end=s.substring(i);
        return start+c+end;
    }
    
    private static boolean isPalindrome(String str){ 
    	  
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
}


// IF YOU NEED REPEATITION USE ARRAYLIST INSTEAD OF SET!!