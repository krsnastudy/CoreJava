package com.prac.core.problem.persisistant;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		List<Object> list = new ArrayList<>();
			while(true) {
				Object obj = new Object();
				System.out.println("Object Created: "+obj.hashCode());
				list.add(obj);
			}
	}

}
