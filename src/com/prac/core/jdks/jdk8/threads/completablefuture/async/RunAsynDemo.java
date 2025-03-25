package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;

public class RunAsynDemo {

	public Void saveEmployees(int noOfRecords) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
			List<Employee> employeeList = new ArrayList<Employee>();

			@Override
			public void run() {
				employeeList = EmployeeDB.fetchEmployees(noOfRecords);
				System.out.println(
						"Thread : " + Thread.currentThread().getName() + "  & Employees Size: " + employeeList.size());
			}
		});

		return runAsyncFuture.get();
	}

	public Void saveEmployeesWitLamda(int noOfRecords) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(4);

		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {

			List<Employee> employeeList = EmployeeDB.fetchEmployees(noOfRecords);
			System.out.println(
					"Thread : " + Thread.currentThread().getName() + "  & Employees Size: " + employeeList.size());
		}, executor);

		runAsyncFuture.toCompletableFuture();
		return runAsyncFuture.get();
	}
}
