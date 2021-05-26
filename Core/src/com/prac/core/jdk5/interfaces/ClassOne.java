package com.prac.core.jdk5.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ClassOne {

	public static List methodOne(int i) {
		
		if(i==0) {
			ArrayList<Integer> a = new ArrayList();
			a.add(i);
			return a;
		}else if(i==1) {
			Vector<Integer> v = new Vector<>();
			v.add(i);
		}
		return null;
	}
}
