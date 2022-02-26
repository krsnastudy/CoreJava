package com.prac.core.problem.gen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] res = twoSum(nums, target);
		// Stream.of(res).forEach(x->System.out.print(x+" "));
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
		SingleTonEx s1 = SingleTonEx.getInstance();
		SingleTonEx s2 = SingleTonEx.getInstance();
		SingleTonEx s3 = SingleTonEx.getInstance();
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		
		try {
//          Constructor constructor = SingtonEx.class.getDeclaredConstructor();
//          constructor.setAccessible(true);
//          objTwo = (SingtonEx) constructor.newInstance();

			// load class
			Class c = Class.forName("com.prac.core.problem.gen.SingleTonEx");
			// get all constructors (whether public or private)
			Constructor[] constructors = c.getDeclaredConstructors();
			// suppress access check errors
			constructors[0].setAccessible(true);
			// instance no 1
			System.out.println(constructors[0].newInstance());
			// instance no 2
			System.out.println(constructors[0].newInstance());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
				e.printStackTrace();
		} catch (IllegalAccessException e) {
				e.printStackTrace();
		} catch (IllegalArgumentException e) {
				e.printStackTrace();
		} catch (InvocationTargetException e) {
				e.printStackTrace();
		}
		
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					// System.out.println(i+" - "+j);
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
