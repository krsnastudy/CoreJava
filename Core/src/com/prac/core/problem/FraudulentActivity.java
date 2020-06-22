package com.prac.core.problem;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class FraudulentActivity {

	public static void main(String[] args) {
//		int[] expenditure = {10, 20, 30, 40, 50};
//		int[] expenditure = {50, 30, 10, 40, 20, 90, 34, 45, 9, 12, 56, 89, 919, 121, 45, 121};
//		int[] expenditure = {1, 2, 3, 4, 4};
//		int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 2};
//		int[] expenditure = {200, 2, 4, 201, 3, 6, 8, 4, 312, 12, 11, 10, 87, 99};
		
		int size = 23; int maxValue=200; int trailingDays=9; 
		int[] expenditure = new int[size];
		
		expenditure = getArray(size, maxValue);
		activityNotifications(expenditure, trailingDays);
	}

	private static int activityNotifications(int[] expenditure, int d) {

		int notificationCount=0;
		int n = expenditure.length;
		
		if(expenditure.length<d) {
			System.out.println("Cannot be Processed trailingDays > Days Values ");
			return notificationCount;
		}
		
		for(int i=0; (i+d)<n; i++) {
			int[] sub = new int[d]; 
			double median =0.0;
			
			sub = Arrays.copyOfRange(expenditure, i, (i+d));
			
			System.out.print("Iteration["+i+"]:");
			System.out.print(" Array:"+Arrays.toString(sub));

			if(!check201(sub)) {
				median = getMedian(sub);
				System.out.print(" Median"+Arrays.toString(sub)+"="+median+" [(2X)] {"+(2*median));
				
					System.out.print("<="+expenditure[i+d]+"} [Expenditure]");
					if((expenditure[i+d])>=(2*median)) {
						notificationCount++;
						System.out.print(" nCount: "+notificationCount+"\n");
					}else {
						System.out.print(" Failed, No Notification "+"\n");
					}
			}else {
				System.out.print(" --> Skipped by Condition [0<=expenditure[i]<=200]"+"\n");
			}
		}
		
		System.out.println("Notifications Count: "+notificationCount);
		return 0;
    }
	
	private static boolean check201(int[] values) {
		boolean ch201=false;
		Predicate<Integer> greaterThanTen = (i) -> i > 200; 
		
		for (int i : values) {
			if(greaterThanTen.test(i)) {
				ch201=true;
				break;				
			}
			
			/*
			 * if(i>200) { ch201=true; break; }
			 */
		}
		
		return ch201;
	}

	private static double getMedian(int[] values) {
		     // sort array
		     Arrays.sort(values);
		     double median;
		     // get count of scores
		     int totalElements = values.length;
		     // check if total number of scores is even
		     if (totalElements % 2 == 0) {
		        int sumOfMiddleElements = values[totalElements / 2] + values[totalElements / 2 - 1];
		        // calculate average of middle elements
		        median = ((double) sumOfMiddleElements) / 2;
		     } else {
		        // get the middle element
		        median = (double) values[values.length / 2];
		  }
		  return median;
		 }

	private static int[] getArray(int size, int maxValue) {
		int[] arr = new int[size];
		int minValue =1;
		return getStreamOfRandomIntsWithRange(size, minValue, maxValue);
	}
	
	public static int[] getStreamOfRandomIntsWithRange(int num, int min, int max) {
		Random random = new Random();
		int[] arr = new int[num];
//	    random.ints(num, min, max).sorted().forEach(x->System.out.print(x+" "));
	    
		arr = random.ints(num, min, max).toArray();
	    System.out.println("Array Created: "+Arrays.toString(arr)+"\n");
	    
	    return arr;
	}
	
} // Main

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting&h_r=next-challenge&h_v=zen