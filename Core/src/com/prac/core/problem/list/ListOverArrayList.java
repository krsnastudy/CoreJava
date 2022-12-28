package com.prac.core.problem.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListOverArrayList {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("a");myList.add("b");myList.add("c");
        System.out.println(myList);

        myList = new LinkedList<String>();
        myList.add("3");myList.add("4");myList.add("5");
        System.out.println(myList);
    }
}
