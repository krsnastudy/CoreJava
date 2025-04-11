package com.prac.core.problem.companies.CTS.apr2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        /** Count of chars */
        String str = "radhakrishna";

        Map<Character, Long> collect = str.chars()
                .mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("JDK8 : " + collect);

        Map<Character, Integer> map = new HashMap<>();
        char[] cArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            map.merge(cArray[i], 1, Integer::sum);
        }
        System.out.println("JDK5 : " + map);

//op : 4, 6, 3 2 7 9 -- print non repeated numbers
        List<Integer> list = Arrays.asList(1, 1, 4, 5, 6, 5, 3, 2, 7, 9, 5);
//        System.out.println(list);

        List<Integer> collect1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() == 1)
                .map(m -> m.getKey())
                .collect(Collectors.toList());
        System.out.println("non repeated numbers: " + collect1);
    }
}


/***
 *  Query 7th Highest salary
 *
 * SELECT * FROM (
 *            SELECT
 *                 emp_name, emp_salary,
 *                 DENSE_RANK() OVER (ORDER BY emp_salary DESC) AS rank
 *            FROM employee
 * ) AS subquery WHERE rank = 7;
 *
 * */