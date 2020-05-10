package com.prac.core.mem;

public class SystemExit {

	public static void main(String[] args) {
		System.out.println("Test");
		
		try{
			System.out.println("I am in try block");
			System.exit(1);
		} catch(Exception ex){
			System.out.println("I am in Catch block");
			ex.printStackTrace();
		} finally {
			System.out.println("I am in finally block!!!");
		}
	}
}

/*
exit(0) : Generally used to indicate successful termination.
exit(1) or exit(-1) or any other non-zero value – Generally indicates unsuccessful termination.

Terminates the currently running Java Virtual Machine. 
The argument serves as a status code; by convention, a nonzero status code indicates abnormal termination. 

This method calls the exit method in class Runtime. This method never returns normally. 
The call System.exit(n) is effectively equivalent tothe call: 

Runtime.getRuntime().exit(n)
 
Parameters:status exit status.Throws:SecurityException - 
if a security manager exists and its checkExitmethod doesn't allow exit with the specified status.
See Also:java.lang.Runtime.exit(int)

*/