package com.prac.core.problem.gen;

import com.prac.core.jdks.jdk5.arrays.Array;

import java.util.List;

public class MaxAverageScore {

    static String studentRecord(String[][] S, int N) {

        // code here
        int maxi = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < N; i++) {
            int avg = (Integer.parseInt(S[i][1]) + Integer.parseInt(S[i][2]) + Integer.parseInt(S[i][3])) / 3;
            if (avg > maxi) {
                maxi = avg;
                result = S[i][0];
            } else if (avg == maxi) {
                result = result + " " + S[i][0];
            }
        }
        return result + " " + maxi;
    }

    public static void findAverage(List<Array> marks){
        
    }


    public static void main(String[] args) {
        int N = 2;
        String[][] file = {{"Shrikanth", "20", "30", "10"},
                {"Ram", "100", "50", "10"}};

        System.out.println(studentRecord(file, N));
    }
}
