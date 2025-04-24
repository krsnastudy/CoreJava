package com.prac.core.jdks.jdk8.arrlist.mylist;

public class MyArrayListImpl {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Krishna");
        list.add("Java");

//        System.out.println("First element: " + list.getFirst());
        System.out.println("Full list: " + list);
    }
}
