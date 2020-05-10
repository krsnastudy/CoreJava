package com.prac.core.arrlist;

import java.util.ArrayList;

public class JavaArrayListCloneExample {
 
    public static void main(String[] args) {
        
        //create StringBuilder object
        StringBuilder sbText = new StringBuilder("I am object1");
        
        ArrayList<StringBuilder> aList1 = new ArrayList<StringBuilder>();
        aList1.add(sbText);
        
        //clone the ArrayList
        ArrayList<StringBuilder> aList2 = (ArrayList<StringBuilder>)aList1.clone();
        
        //change the StringBuilder object
        sbText.replace(11, 12, "2");
        
        System.out.println("Original ArrayList Contents");
        System.out.println(aList1);
        
        System.out.println("Cloned ArrayList Contents");
        System.out.println(aList2);
        
    }
}
