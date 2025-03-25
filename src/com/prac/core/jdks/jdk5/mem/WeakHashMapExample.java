package com.prac.core.jdks.jdk5.mem;

import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object key1 = new Object(); // Strong reference
        Object key2 = new Object(); // Strong reference

        weakMap.put(key1, "Java");
        weakMap.put(key2, "Spring");

        System.out.println("Before GC: " + weakMap);

        // Remove strong reference
        key1 = null;

        // Force Garbage Collection
        System.gc();

        // Wait for GC to finish
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("After GC: " + weakMap);
    }
}
