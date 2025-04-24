package com.prac.core.jdks.jdk8.arrlist.mylist;

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        System.out.println("Adding element: " + e);
        return super.add(e);  // retain original functionality
    }

/*    public E getFirst() {
        return isEmpty() ? null : get(0);
    }*/
}
