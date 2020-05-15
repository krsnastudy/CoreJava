package com.prac.core.problem;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPallindrome {
	public static Set<String> result = new HashSet<>();
	public static Map<Integer, HashSet<String>> combinationsMap = new HashMap<>();
	public static Map<Integer, HashSet<String>> finalRes = new HashMap<>();
	public static Map<Integer, HashSet<String>> pallinRes = new HashMap<>();
	public static TreeSet<String> hSet = new TreeSet<>();
	
   public static void main(String[] args){
     String inputString = "week";
     
     Combinations combobj= new Combinations(inputString);
     combobj.combine();
     hSet = combobj.getData();
//     System.out.println("Combinations: "+hSet);
     
     prepareRawData(inputString);
//     System.out.println("combinationsMap: "+combinationsMap);
     
     processData();
//     System.out.println("Permutation Data: "+finalRes);
     
     palindromeData();
//     System.out.println("Pallindromes Data: "+pallinRes);
     
     printDecision();
     
   } // pvsm
   
   public static void printDecision() {
	    Map<Object, Object> res =
	    		pallinRes.entrySet().stream()
	    	        .collect(Collectors.toMap(
	    	            e -> e.getValue(),
	    	            e -> e.getValue().size()
	    	        ));
	    
	    System.out.println("\nPallindromes Result{(Set), (Set.size)}: \n"+res);
	    		
	    OptionalInt max = res.entrySet()
	    	      .stream()
	    	      .mapToInt(v -> (int)v.getValue())
	    	      .max();

//	    System.out.println(max);

		Collection<Object> lMax = res.entrySet()
	    		.stream()
	    		.filter(entry -> (int)entry.getValue()==max.getAsInt())
	    		.map(Map.Entry::getKey)
	    		.collect(Collectors.toList());
	    
		System.out.println("\nMax size of Pallindrome is: "+max.getAsInt());
		System.out.print("Pallindromes are: ");
		lMax.forEach(a->System.out.print(a+" "));
   }
      
   public static void palindromeData () {
	     for(Map.Entry<Integer, HashSet<String>> entry : finalRes.entrySet()) {
				  HashSet<String> eSet = new HashSet<String>();
				  HashSet<String> dSet = entry.getValue();
//				  System.out.println("Processing Length: "+entry.getKey());
				  for (String strPallindrome : dSet) {
					  //System.out.println("strPallindrome: "+strPallindrome);
					  if(palindromeChecker(strPallindrome)) {
						  eSet.add(strPallindrome);
					  }
				  }
				  
				  pallinRes.put(entry.getKey(), eSet);
		   }
   }
   
   public static boolean palindromeChecker (String str){  
	       StringBuilder sb=new StringBuilder(str);  
	       sb.reverse();  
	       String rev=sb.toString();  
	       if(str.equals(rev)){  
	           return true;  
	       }else{  
	           return false;  
	       }  
	   }  
      
   private static void processData() {
	   for(Map.Entry<Integer, HashSet<String>> entry : combinationsMap.entrySet()) {
//		   preparePallindrome(entry);
			  HashSet<String> eSet = new HashSet<String>();
			  HashSet<String> dSet = entry.getValue();
//		System.out.println("Length: "+entry.getKey()+" - Size: "+entry.getValue().size());	  
			  for (String string : dSet) { 
//				  Set<String> se=find(input);
				  eSet.addAll(find(string));
			  }
			  
			  finalRes.put(entry.getKey(), eSet);
	   }
   }
   
   @SuppressWarnings("unchecked")
   private static void prepareRawData(String inputString) {
	   for(int i=2;i<=inputString.length();i++) {
		   HashSet<String> set = new HashSet<String>();
		   for (String string : hSet) {
//			   set.add(string);
				  if(string.length()==i) { set.add(string); }
		   }
		   combinationsMap.put(i, set);
	   }
   }
    
    public static String comb(String s,char c,int i){
        String start=s.substring(0,i);
        String end=s.substring(i);
        String rString=start+c+end;
        
        return rString;
    }

    public static HashSet<String> find(String s){
    	HashSet<String> ss=new HashSet<String>();
//    	System.out.println("In find(): "+s);
        if(s==null){
            return null;
        }
        if(s.length()==0){
            ss.add("");
        }else{
            char c=s.charAt(0);
            String st=s.substring(1);
            HashSet<String> qq=find(st);
            for(String str:qq){
                for(int i=0;i<=str.length();i++){
                	ss.add(comb(str,c,i));
/*
 * if(isPalindrome(comb(str,c,i))){ ss.add(comb(str,c,i)); }
 */
                }
            }
        }
        return ss;
    }    
    
} // Main