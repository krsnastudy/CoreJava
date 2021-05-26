package com.prac.core.problem.gen;

import java.util.Scanner;

public class CostOfBalloons {
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt(); 
        int green, purple, participants, j, totalCost, p1,p2;
 
        for(int i=1; i<=testCases; i++){
            totalCost=0;
            System.out.print("Enter Purple: ");
            green = s.nextInt(); 
            System.out.print("Enter Green: ");
            purple = s.nextInt(); 
            
            System.out.print("Enter No. of Participants: ");
            participants = s.nextInt(); 
            for(j=1;j<=participants; j++){
            	System.out.print("Enter First Value: ");	
                p1 = s.nextInt();
                if(p1==1){
                    if(i%2 ==0){
                        totalCost += purple;
                    }else{
                        totalCost += green;
                    }
                }
                System.out.print("Enter Second Value: ");
                p2 = s.nextInt();
                if(p2 ==1){
                    if(i%2 ==0){
                        totalCost += green;
                    }else{
                        totalCost += purple;
                    }
                }
            }
            System.out.println(totalCost);
        }
 
    }
}

//https://www.hackerearth.com/submission/42344278/
// https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/activity/