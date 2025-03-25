package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;

public class CompletableFutureDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsynDemo r = new RunAsynDemo();
		SupplyAsyncDemo s = new SupplyAsyncDemo();
		
		int noOfRecords=15;
		List<Employee> employeeList = new ArrayList<Employee>();
		
		//CompletableFuture.runAsync
		r.saveEmployees(noOfRecords);
		r.saveEmployeesWitLamda(noOfRecords);
		
		//CompletableFuture.supplyAsync
		employeeList = s.saveEmployees(noOfRecords);
		System.out.println("\nsupplyAsync saveEmployees: "+employeeList.size());
		
		employeeList = new ArrayList<Employee>();
		employeeList = s.saveEmployeesWithExecutor(noOfRecords);
		System.out.println("supplyAsync saveEmployeesWithExecutor: "+employeeList.size());
	}

}
