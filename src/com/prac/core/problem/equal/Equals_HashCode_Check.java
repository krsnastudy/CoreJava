package com.prac.core.problem.equal;

public class Equals_HashCode_Check {

	public static void main(String[] args) {
		User user1 = new User("java", "pass");
		User user2 = new User("java", "pass");

		System.out.println("user1.equals(user2): " + user1.equals(user2));
		System.out.println("user1.hashCode()==user2.hashCode(): " + (user1.hashCode() == user2.hashCode()));
		System.out.println(user1.hashCode()+"  :Identity HashCode: "+System.identityHashCode(user1));
	}
}

/*
 * Lancesoft
 */