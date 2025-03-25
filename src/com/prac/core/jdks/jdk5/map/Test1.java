package com.prac.core.jdks.jdk5.map;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		Map<Integer, String> hMap = new HashMap<>();
		
		for(int i=1; i<10; i++) {
			hMap.put(i, ("Number "+i));
		}
		
		for(Map.Entry<Integer, String> e : hMap.entrySet()) {
			System.out.println(e.getKey()+" --> "+e.getValue() );
		}
	}

}
