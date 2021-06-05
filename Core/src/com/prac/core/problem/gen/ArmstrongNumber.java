package com.prac.core.problem.gen;

public class ArmstrongNumber {

	public static void main(String[] args){
		int res=0; int check=371;
		res=checkArmstrong(check);
		System.out.println(res==check ? check+" is an Armstrong Number": check+" is Not an Armstrong Number");
	}

	public static int checkArmstrong(int number){
		String str = number+""; int res=0;
		char[] cArr = str.toCharArray();
		
		for(int i=0;i<cArr.length;i++) {
			int num = Character.getNumericValue(cArr[i]);
//			int temp = num*num*num;
			int temp = (int) Math.pow(num, 3);
			res = res + temp;
		}
		
		return res;
	}
}
