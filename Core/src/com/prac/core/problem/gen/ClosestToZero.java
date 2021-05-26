package com.prac.core.problem.gen;

import java.util.Arrays;

public class ClosestToZero {
 
    public static void main(String[] args) {
        
        int[] testingArray = {109, 60, -10, 70, -80, 85}; //{4,7,9,2,-2};
        
        int result = getClosestToZero(testingArray);
        
        System.out.println("The Closest Number To Zero in this Array is : " + result);
 
    }
 
    public static int getClosestToZero(int[] a) {
        int currentValue = 0;
        int closestVal = a[0];
        Arrays.sort(a);
 
        for (int index = 0; index < a.length; index++) {
            currentValue = a[index] * a[index];
            if (currentValue <= (closestVal * closestVal)) {
            	System.out.println(index+" Iteration - currentValue: "+currentValue+" closestVal: "+closestVal);
                closestVal = a[index];
            }else {
            	System.out.println(index+" Iteration - currentValue: "+currentValue+" closestVal: "+closestVal);
            }
        }
        return closestVal;
    }
}
