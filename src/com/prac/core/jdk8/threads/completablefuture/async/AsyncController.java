package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncController {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		
		AsyncService service = new AsyncService();
		
		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();

		// Wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
		
		System.out.println("EmployeeAddress--> " + employeeAddress.get());
		System.out.println("EmployeeName--> " + employeeName.get());
		System.out.println("EmployeePhone--> " + employeePhone.get());
	}

}
