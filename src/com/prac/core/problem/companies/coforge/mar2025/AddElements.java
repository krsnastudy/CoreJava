package com.prac.core.problem.companies.coforge.mar2025;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class AddElements {

    public static void main(String[] args) {
        String s1 = new String("JAVA");
        String s2 = "JAVA";

        System.out.println("s1 ref: " + System.identityHashCode(s1));
        System.out.println("s2 ref: " + System.identityHashCode(s2));

        // Optional: print as hex like Object.toString()
        System.out.println("s1 ref (hex): " + Integer.toHexString(System.identityHashCode(s1)));
        System.out.println("s2 ref (hex): " + Integer.toHexString(System.identityHashCode(s2)));

        HashMap<String, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s2, 2);
        System.out.println("HashMap: " + map+"\n"); // Output: HashMap: {JAVA=2}

        /** **/
        String s3 = new String("JAVA");
        String s4 = "JAVA";

        System.out.println("s3 ref: " + System.identityHashCode(s3));
        System.out.println("s4 ref: " + System.identityHashCode(s4));

        // Optional: print as hex like Object.toString()
        System.out.println("s3 ref (hex): " + Integer.toHexString(System.identityHashCode(s3)));
        System.out.println("s4 ref (hex): " + Integer.toHexString(System.identityHashCode(s4)));

        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(s3, 1);
        identityHashMap.put(s4, 2);
        System.out.println("IdentityHashMap: " + identityHashMap);  // Output: IdentityHashMap: {JAVA=2, JAVA=1}

        System.out.println();
        System.out.println("s1 ref (toBinaryString): " + Integer.toBinaryString(System.identityHashCode(s1)));
        System.out.println("s1 ref (toHexString): " + Integer.toHexString(System.identityHashCode(s1)));
        System.out.println("s1 ref (toOctalString): " + Integer.toOctalString(System.identityHashCode(s1)));
        System.out.println("s1 ref (toUnsignedString): " + Integer.toUnsignedString(System.identityHashCode(s1)));
        System.out.println("s1 ref (toUnsignedLong): " + Integer.toUnsignedLong(System.identityHashCode(s1)));
        System.out.println("s1 ref (highestOneBit): " + Integer.highestOneBit(System.identityHashCode(s1)));
        System.out.println("s1 ref (lowestOneBit): " + Integer.lowestOneBit(System.identityHashCode(s1)));
    }
}

/*
 * asked in coforge - 20-Mar-2025
 * size of map
 * */