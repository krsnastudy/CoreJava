package com.prac.core.jdk5.arrlist;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List aList = new ArrayList<Integer>();
		
		aList.add("1");
		aList.add("2");
		aList.add("3");
		aList.add("4");
		aList.add("5");
		
		System.out.println("Before Modification: "+aList);
		getArrList((ArrayList) aList);
	}

	public static void getArrList(ArrayList aList) {

		if(aList.size()>4) {
			aList.add("6"); 	
		}
		
		System.out.println("After Modification: "+aList);
		
		for(int i=0; i<aList.size();i++) {
			if(i>4) {
				aList.add("7"); 
			}
		}
		
		System.out.println("After Modification: "+aList);
		
		/*
		 * try { if(aList.size()>0) { aList.forEach(x->System.out.print(x+" "));
		 * System.out.println(); aList.add("6"); }
		 * 
		 * System.out.println("After Modification: "+aList); }catch(Exception e){
		 * System.out.println("In Catch Block"); e.printStackTrace(); }
		 */
	}
}