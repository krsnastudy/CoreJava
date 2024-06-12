package com.prac.core.jdk5.map;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
//		HashMap<String, String> hMap = new HashMap<>();
		HashMap hMap = new HashMap<>();
		hMap.put(2, "abc"); 
/* Compile Time Error 
 * The method put(String, String) in the type HashMap<String,String> 
 * is not applicable for the arguments (int, String)
 */
		hMap.put("2", "abc");
		
		System.out.println(hMap);
		
		HashMap<Integer, String> h1 = new HashMap<>();
		h1.put(2,"abc");
		h1.put(Integer.parseInt("2"),"abc");
		System.out.println(h1);
	}

}
