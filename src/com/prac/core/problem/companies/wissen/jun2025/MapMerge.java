package com.prac.core.problem.companies.wissen.jun2025;

import java.util.Map;
import java.util.TreeMap;

public class MapMerge {
    public static void main(String[] args) {

        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        Map<Integer, Integer> map3 = new TreeMap<>();

        map1.put(1, 10);
        map1.put(2, 27);
        map1.put(3, 48);
        map1.put(4, 15);
        map1.put(1, 5);

        map2.put(1, 15);
        map2.put(5, 95);
        map2.put(4, 39);
        map2.put(2, 47);
        map2.put(6, 31);

        System.out.println("Given Map1 :: "+map1);
        System.out.println("Given Map2 :: "+map2);

//        map3.putAll(map1);
        map1.entrySet().stream().forEach(e->map3.merge(e.getKey(), e.getValue(), Integer::sum));
        System.out.println("Iteration1 Map3 :: "+map3);

        map2.entrySet().stream().forEach(e->map3.merge(e.getKey(), e.getValue(), Integer::sum));
        System.out.println("Iteration2 Map3 :: "+map3);
    }
}
