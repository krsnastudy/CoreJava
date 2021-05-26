package com.prac.core.problem.gen;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
enum AbbreviationOfDays{
   A(1), B(2), C(3), D(4), E(5), F(6),
   G(7),H(8),I(9),J(10),K(11),L(12),M(13),N(14),O(15),P(16),
   Q(17),R(18),S(19),T(20),U(21),V(22),W(23),X(24),Y(25),Z(26);
	
   private Integer abbreviation;
   
   public Integer getAbbreviation() {
       return this.abbreviation;
   }
   
   AbbreviationOfDays(Integer abbreviation) {
           this.abbreviation = abbreviation;
   }
   
   AbbreviationOfDays(String str) {
	   this.abbreviation = null;
   }
}
public class CharSum {
   public static void enumFields(String str) {
       AbbreviationOfDays[] abbreviationOfDays = AbbreviationOfDays.values();
       int val=0;
       char[] c = str.toCharArray();
       
       Map<Object, Integer> alpha =
    		   Stream.of(abbreviationOfDays)
    		   .collect(Collectors.toMap(day->day.name(), day->day.getAbbreviation()));
       
       for (char d : c) {
		if(alpha.containsKey(Character.toString(d))){
			val = val + alpha.get(Character.toString(d));
		}
       }
       
       
       Map<Character, Integer> charsWithCountMap = new HashMap<>();
        List<Character> list = str.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
		list.stream().forEach(x -> charsWithCountMap.merge(x, 1, Integer::sum));
		
//		charsWithCountMap.forEach((x,y)->System.out.println(x+" "+y));
       
//		Long sum = charsWithCountMap.forEach((x,y)-> y*alpha.get(x));

	/*	int sum = (int) charsWithCountMap.entrySet().stream()
				.collect(Collectors.reducing(0, ((x,y)->y*(alpha.get(x))));*/
				
				
				 /*Integer sum = (Character,Integer) charsWithCountMap.entrySet().stream()
			                .map((x,y)-> y.multiply(alpha.get(x)))    // map
			                .reduce(0 ,Integer::sum);*/
       
       System.out.println("Total: "+val);
   }
   
   public static void main(String[] args) {
	   String str = "AbcDEa";
	   enumFields(str.toUpperCase());
	  // System.out.println(enumFields());
   }
   
}