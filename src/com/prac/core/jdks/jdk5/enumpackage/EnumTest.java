package com.prac.core.jdks.jdk5.enumpackage;

public class EnumTest {

	public static void main(String[] args) {

		System.out.println(EnumConstants.ALL.getKey() + " -- " + EnumConstants.ALL.getValue());
		System.out.println(EnumConstants.SUNDAY.getKey() + " -- " + EnumConstants.SUNDAY.getIntValue());
	}

}
