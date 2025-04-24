package com.prac.core.problem.companies.wissen.jun2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashmapTest {
    public static void main(String[] args) {

        Map<Object, String> map = new HashMap<>();
        map.put(2, "Java");
        map.put("2", "Java");

        System.out.println(map);


        /**/
        List<String> list = new ArrayList<>();
//        list.add(5, "krishna");
        list.forEach(System.out::println);
        /*Error: Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 0*/
    }
}

/*
* You're adding two distinct keys (Integer 2 and String "2") to a HashMap, so both are stored and printed. Output will be: {2=Java, 2=Java}
* ✅ Key Takeaways:
* Java HashMap keys are compared using .equals() and hashCode().
* 2 (int/Integer) and "2" (String) are different — so both are stored as separate entries.
*
* But under the hood:
* - The first `2` is an `Integer`
* - The second `"2"` is a `String`
* They are **not equal**, because: Integer.valueOf(2).equals("2") // false
* And their `hashCode()` values are also different: Integer.valueOf(2).hashCode() = 2
* "2".hashCode() = 50

*
* */