package test.java;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, null);
        map.put(2, null);
        map.put(null, 1);
        map.put(null, 2);
        System.out.println(map);
    }
}