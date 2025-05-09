package com.prac.core.jdks.jdk5.string;

public class StringIntern {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = "ABC";

		System.out.println("B4 Intern() s1==s2 --> " + (s1 == s2));
		System.out.println(s1.hashCode() + " <--> " + s2.hashCode());

		s1 = s1.intern();

		System.out.println("\nA4 Intern() s1==s2 --> " + (s1 == s2));
		System.out.println(s1.hashCode() + " <--> " + s2.hashCode());
	}

}
/*
 * String Interning is a method of storing only one copy of each distinct String
 * Value, which must be immutable. By applying String.intern() on a couple of
 * strings will ensure that all strings having the same contents share the same
 * memory
 * 
 * For example, if a name �Amy� appears 100 times, by interning you ensure only
 * one �Amy� is actually allocated memory.
 * 
 * intern() method : In Java, when we perform any operation using intern()
 * method, it returns a canonical representation for the string object. A pool
 * is managed by String class.
 * 
 * When the intern() method is executed then it checks whether the String equals
 * to this String Object is in the pool or not. If it is available, then the
 * string from the pool is returned. Otherwise, this String object is added to
 * the pool and a reference to this String object is returned. It follows that
 * for any two strings s and t, s.intern() == t.intern() is true if and only if
 * s.equals(t) is true.
 * 
 * It is advised to use equals(), not ==, to compare two strings. This is
 * because == operator compares memory locations, while equals() method compares
 * the content stored in two objects.
 * 
 */
