package com.prac.core.problem.gen;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
	private static final Scanner scanner = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	
    	 int arrSize = n;
    	 int itr = queries.length;
    	 long[] arr = new long[arrSize];
    	 
//    	 System.out.println("arrSize: "+arrSize);
//    	 System.out.println("Operations: "+itr);
    	 
    	 long max = 0;
    	 
         for (int i = 0; i < itr; i++) {
        	 int sIndex=0; int eIndex=0;
        	 int factor = 0;
        	 
        	 sIndex = queries[i][0]-1;
        	 eIndex = queries[i][1];
        	 factor = queries[i][2];
        	 
        	 for (int k = sIndex; k < eIndex; k++) {
                 arr[k] += factor; 
                 
                 if(max  <  arr[k]) {
                 max = arr[k];
                 }
             }
         }
         
//         System.out.println("max value: "+max);
//         System.out.println("Arrays B4: "+Arrays.toString(arr));
    	 
//         Arrays.sort(arr);
//         System.out.println("Arrays A4: "+Arrays.toString(arr));
//         System.out.println("Max: "+arr[arr.length-1]);
         
//         return arr[arr.length-1];
         return max;
    }
	
    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

//        System.out.println("Size of Array: "+n);
//        System.out.println("Size of Ops: "+m);
        
        for (int i = 0; i < m; i++) {
        	//System.out.println("Input Iteration: "+i);
            String[] queriesRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
//            	System.out.println("Inside: "+i+" -- "+j);
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * bufferedWriter.close();
		 */

        scanner.close();
    }

    public static void main1(String[] args)
    {
        Scanner in = new Scanner(System.in);
            
        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];

        int a;
        int b;
        int k;
        while (M-- > 0)
        {
            a = in.nextInt() - 1;
            b = in.nextInt();
            k = in.nextInt();
                
            arr[a] += k;
            if (b < N) {
            	arr[b] -= k;
            }
            
            System.out.println(M+" Iteration: "+Arrays.toString(arr));
        }
        in.close();

        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int value : arr)
        {
            sum += value;
            if (sum > max)
            {
                max = sum;
            }
        }
            
        System.out.println(max);
    }
}


// https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays