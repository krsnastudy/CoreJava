package com.prac.core.system;

import java.lang.reflect.Method;

public class ClassDemo {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
String javaClassName = "java.time.LocalDate";
	      try {
	         Class cls = Class.forName(javaClassName);
	         System.out.println("Java Class["+javaClassName+"] Methods are: ");
	      
	         /* returns the array of Method objects representing the public 
	            methods of this class */
	         Method m[] = cls.getMethods();
	         for(int i = 0; i < m.length; i++) {
	            System.out.println(m[i]);
	         }
	      } catch (Exception e) {
	         System.out.println("Exception: " + e);
	      }
	   }
}
