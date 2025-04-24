package com.prac.core.jdks.jdk8.arrlist.mylist;

import java.util.List;

public class MyListImpl {
    public static void main(String[] args) {
        List<String> list = new MyList<>();
        list.add("Krishna");
        list.add("Java");

        System.out.println(list.get(0)); // Krishna
        System.out.println(list.size()); // 2
    }
}
