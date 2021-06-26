package com.prac.core.jdk5.design.singleton;

public class SingleTonTest {

	public static void main(String[] args){
		SingtonEx s1 = SingtonEx.getInstance();
		SingtonEx s2 = s1;
		
		System.out.println("SingleTon s1: "+s1.hashCode());
		System.out.println("SingleTon s2: "+s2.hashCode());
		
	}

}
