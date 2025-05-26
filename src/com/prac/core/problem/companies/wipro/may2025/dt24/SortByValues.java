package com.prac.core.problem.companies.wipro.may2025.dt24;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValues {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Lohith", "Jammu");
        map.put("Mukesh", "Assam");
        map.put("Vinay", "Delhi");
        map.put("Rakesh", "Andhra");
        map.put("Arun Gowda", "Karnataka");

        System.out.println(map);

        /* sortByValue */
        LinkedHashMap<String, String>
                sortByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        System.out.println("sortByValue: " + sortByValue);

        /* sortByKey */
        Map<String, String>
                sortByKey = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        System.out.println("  sortByKey: " + sortByKey);

    }
}
