package com.prac.core.jdks.jdk5.arrlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Remove {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3));
        System.out.println("list B4 --> "+list);
        list.remove(1);
        System.out.println("list A4 --> "+list);

        Collection<Integer> collection = new ArrayList<>(List.of(1,2,3));
        System.out.println("collection B4 --> "+collection);
        collection.remove(1);
        System.out.println("collection A4 --> "+collection);
    }
}
