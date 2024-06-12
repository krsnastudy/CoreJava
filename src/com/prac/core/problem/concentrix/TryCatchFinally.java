package com.prac.core.problem.concentrix;

public class TryCatchFinally {

	public static void main(String[] args) {
		try {
			System.exit(0);// normal termination - Successful - zero
			System.exit(-1);//Exit with some Error
			System.exit(1);//one or any positive integer // exit with some Information message
			System.out.println(1/0);
		}catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println("Test"); //Syntax error on token "finally", delete this token
		finally {
			System.out.println("Finally");
		}
	}
}

/*
Terminates the currently running Java Virtual Machine. The argument serves as a status code; 
by convention, a nonzero statuscode indicates abnormal termination. 

This method calls the exit method in class Runtime. This method never returns normally. 

The call System.exit(n) is effectively equivalent tothe call: 

 Runtime.getRuntime().exit(n)

*/