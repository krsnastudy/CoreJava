package com.prac.core.interfaces;

import java.util.HashMap;
import java.util.Map;

public class InterfaceTwoImpl implements InterfaceOne{

	public static void main(String[] args) {
		
	}

	@Override
	public Map<String, String> method1() {
		Map<String, String> m = new HashMap<>();
		
		m.put("Key1","Value1");
		m.put("Key2","Value2");
		m.put("Key2","Value3");
		return m;
	}

}
