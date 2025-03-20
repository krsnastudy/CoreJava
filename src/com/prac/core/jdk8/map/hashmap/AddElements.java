package com.prac.core.jdk8.map.hashmap;

import java.util.HashMap;

public class AddElements {

    public static void main(String[] args) {
        String s1 = new String("JAVA");
        String s2 = "JAVA";

        HashMap<String, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s2, 2);
        System.out.println(map);
    }
}

/*
* asked in coforge - 20-Mar-2025
* */