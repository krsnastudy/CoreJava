package com.prac.core.problem;

class TestClass {
    public static void main(String args[] ) throws Exception {
          
        java.util.Scanner s = new java.util.Scanner(System.in);
        int n = s.nextInt(); 

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i]=s.nextInt();
        }
        
        long answer=1;
		int pow = (int) (java.lang.Math.pow(10, 9)+7);
		
		for (int i = 0; i < a.length; i++) {
			answer = (answer*a[i])%pow;
		}

        System.out.println(answer);
    }
}
