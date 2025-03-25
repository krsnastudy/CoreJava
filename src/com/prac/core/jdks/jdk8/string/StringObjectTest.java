package com.prac.core.jdks.jdk8.string;

public class StringObjectTest {
    public static void main(String[] args) {
        String s1 = new String("RadhaKrishna");
        String s2 = "RadhaKrishna"; // SCP reference
        String s3 = new String("RadhaKrishna");

        System.out.println(s1 == s2); // false (Heap != SCP)
//        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3); // false (Two different heap objects)
        System.out.println(s2 == "RadhaKrishna"); // true (Both refer to SCP)

        System.out.println(s1.hashCode() + " -- " + s2.hashCode());
        System.out.println("****************");

        String str1 = new String("Hello").intern();
        String str2 = new String("Hello").intern();

        System.out.println(str1.hashCode() + " -- " + str2.hashCode() + " --> " + (str1 == str2)); // true (Same SCP reference)

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

/**
 * String s1 = new String("Krishna"); How Many Objects Are Created?
 * This statement creates two objects in memory.
 * <p>
 * Breakdown of Object Creation:
 * String Literal Pool (Heap - String Constant Pool)
 * The string "Krishna" is first checked in the String Constant Pool (SCP).
 * If not already present, a new "Krishna" object is created in the SCP.
 * If it already exists, no new object is created in the SCP.
 * Heap Memory (Outside SCP, Due to new Keyword)
 * new String("Krishna") always creates a new String object in the heap, even if "Krishna" is already present in SCP.
 * <p>
 * Final Outcome
 * If "Krishna" was already present in SCP before executing this statement, only one new object is created (in the heap).
 * If "Krishna" was not in SCP, two new objects are created:
 * One in the String Constant Pool (SCP).
 * One in the heap memory (due to new keyword).
 */