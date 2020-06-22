package com.prac.core.problem;

public class SmallestNumber {

	public static void main(String[] args) {

		boolean found=false;
		int n=20;
		long numberToCheck=n;
		
		while(!found) {
			if(checkDivisor(n, numberToCheck)) {
				found=true;
				break;
			}else {
				numberToCheck++;
				//System.out.println("Else: "+numberToCheck);
			}
		}

//		checkDivisor(n, numberToCheck);
		System.out.println("numberToCheck: "+numberToCheck);
		System.out.println(Integer.MAX_VALUE);
	}

	public static boolean checkDivisor(int n, long numberToCheck) {
		boolean isTrue=true;
//		System.out.print("numberToCheck: "+numberToCheck+" Boolean: ");

		for(int i=1; i<=n;i++) {
//			System.out.println("Iteration: "+i+" --> "+(i%numberToCheck));
			if(numberToCheck !=0 && numberToCheck % i != 0) {
				isTrue=false;
				break;
			}
		}
		
//		System.out.print(isTrue+" \n");
		return isTrue;
	}
}
