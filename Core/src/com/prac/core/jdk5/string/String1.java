package com.prac.core.jdk5.string;

import java.util.HashMap;

public class String1 {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = new String("ABC");
		String str3 = "ABC";
		
		System.out.println("str1 hashCode: "+str1.hashCode()+" - identityHashCode: "+System.identityHashCode(str1));
		System.out.println("str2 hashCode: "+str2.hashCode()+" - identityHashCode: "+System.identityHashCode(str2));
		System.out.println("ABC hashCode: "+str1.hashCode()+" - identityHashCode: "+System.identityHashCode("ABC"));
		
		System.out.println(Integer.toHexString(str1.hashCode()));
		System.out.println(Integer.toHexString(str2.hashCode()));
		System.out.println(Integer.toHexString(str3.hashCode()));
		
		String s1 = "XYZ";
		String s2 = "XYZ";
		String s3 = "XYZ";
		String s4 = "XYZ";
		String s9 = new String("XYZ");
		String s8 = new String("XYZ");
		String s10 = new String("XYZ");
		String s11 = new String("XYZ");
		String s5 = new String("XYZ");
		String s6 = new String("XYZ");
		String s7 = new String("XYZ");
		
		HashMap map = new HashMap();
		
		map.put(s1,1);
		map.put(s2,2);
		map.put(s3,1);
		map.put(s4,2);
		map.put(s9,1);
		map.put(s8,2);
		map.put(s10,1);
		map.put(s11,2);
		map.put(s5,1);
		map.put(s6,2);
		map.put(s7,1);
		System.out.println();
		System.out.println("s1 hashCode: "+s1.hashCode()+" - identityHashCode: "+System.identityHashCode(s1));
		System.out.println("s2 hashCode: "+s2.hashCode()+" - identityHashCode: "+System.identityHashCode(s2));
		System.out.println("s3 hashCode: "+s3.hashCode()+" - identityHashCode: "+System.identityHashCode(s3));
		System.out.println("s4 hashCode: "+s4.hashCode()+" - identityHashCode: "+System.identityHashCode(s4));
		System.out.println("s5 hashCode: "+s5.hashCode()+" - identityHashCode: "+System.identityHashCode(s5));
		System.out.println("s6 hashCode: "+s6.hashCode()+" - identityHashCode: "+System.identityHashCode(s6));
		System.out.println("s7 hashCode: "+s7.hashCode()+" - identityHashCode: "+System.identityHashCode(s7));
		System.out.println("s8 hashCode: "+s8.hashCode()+" - identityHashCode: "+System.identityHashCode(s8));
		System.out.println("s9 hashCode: "+s9.hashCode()+" - identityHashCode: "+System.identityHashCode(s9));
		System.out.println("s10 hashCode: "+s10.hashCode()+" - identityHashCode: "+System.identityHashCode(s10));
		System.out.println("s11 hashCode: "+s11.hashCode()+" - identityHashCode: "+System.identityHashCode(s11));
		
		System.out.println("Map size " + map.size());
		
		map.forEach((x,y)->System.identityHashCode(x));
		
		String a = "RK";
		a="Developer";
		System.out.println(a);

	}

}
