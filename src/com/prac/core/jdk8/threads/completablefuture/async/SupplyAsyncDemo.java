package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.prac.core.jdk8.stream.employee.data.Employee;

public class SupplyAsyncDemo {

	public List<Employee> saveEmployees(int noOfRecords) throws InterruptedException, ExecutionException {
//		System.out.println("saveEmployees");
		CompletableFuture<List<Employee>> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return EmployeeDB.fetchEmployees(noOfRecords);
		});
		return supplyAsyncFuture.get();
	}
	
	public List<Employee> saveEmployeesWithExecutor(int noOfRecords) throws InterruptedException, ExecutionException {
//		System.out.println("saveEmployees");
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		CompletableFuture<List<Employee>> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return EmployeeDB.fetchEmployees(noOfRecords);
		}, executor);
		return supplyAsyncFuture.get();
	}
}
