package com.prac.core.jdks.jdk8.arrlist;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class SafeConcurrentModification {
    public static void main(String[] args) {
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        numbers.stream().forEach(num -> {
            System.out.println("Processing: " + num);
            if (num == 3) {
                numbers.add(6); // No exception here!
            }
        });

        System.out.println("Updated List: " + numbers);
    }
}
