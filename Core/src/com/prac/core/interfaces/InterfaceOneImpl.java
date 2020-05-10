package com.prac.core.interfaces;

import java.util.ArrayList;
import java.util.List;

public class InterfaceOneImpl implements InterfaceOne{

	public static void main(String[] args) {
		InterfaceOne iOne = new InterfaceOneImpl();
		
		((ArrayList<String>) iOne.method1()).forEach(p->System.out.println(p));
	}

	@Override
	public List method1() {
		
		List<String> aList = new ArrayList<>();
		aList.add("RK");
		aList.add("String");
		
		return aList;
	}

}
