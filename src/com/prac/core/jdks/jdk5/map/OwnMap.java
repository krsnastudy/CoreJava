package com.prac.core.jdks.jdk5.map;

import java.util.HashMap;

public class OwnMap extends HashMap<Object, Object>{

	public void printHashMap(HashMap<?, ?> hMap) {
		hMap.forEach((x,y)->System.out.println("Key: "+x+", Value: "+y));
	}
	
}
