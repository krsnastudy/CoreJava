package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;

public class ProcessEmployeeData {
	static final int noOfRec = 100;

	public static void main(String[] args) {
		ProcessEmployeeData.process();
	}

	public static CompletableFuture<Void> process() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		BiConsumer<String, String> biCon = (stage, threadName) -> System.out
				.println("Stage: " + stage + " & ThreadName: " + threadName);

		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
			biCon.accept("In fetchEmployees: ", Thread.currentThread().getName());
//			return EmployeeDB.fetchEmployees(noOfRec);

			List<Employee> employeeList = EmployeeDB.fetchEmployees(noOfRec);
//			employeeList.stream().forEach(i->System.out.println(i.toStringSpecific()));
			return employeeList;
		}, executor).thenApplyAsync((empList) -> {
			biCon.accept("In Salary: ", Thread.currentThread().getName());
			return empList.stream().filter(emp -> emp.geteSal() > 15000).collect(Collectors.toList());
		}, executor).thenApplyAsync((empList) -> {
			biCon.accept("In Name: ", Thread.currentThread().getName());
			return empList.stream().filter(i -> i.getfName().startsWith("S")).collect(Collectors.toList());
		}, executor).thenAcceptAsync((nameList) -> {
			biCon.accept("In Print: ", Thread.currentThread().getName());
			nameList.forEach(ProcessEmployeeData::printName);
		}, executor)

		;

		return voidCompletableFuture;
	}// process()

	public static void printName(Employee emp) {
		System.out.println(emp.getfName() + ", ");
	}
}
