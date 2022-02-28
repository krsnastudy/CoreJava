package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;

public class ProcessEmployeeData {
	static final int noOfRec = 1000;
	static ExecutorService executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ProcessEmployeeData.process().get();
		executor.shutdown();
	}

	public static CompletableFuture<Void> process() {

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
			return empList.stream().filter(emp -> emp.geteSal() > 25000).collect(Collectors.toList());
		}, executor).thenApplyAsync((empList) -> {
			biCon.accept("In EmployeeNumber: ", Thread.currentThread().getName());
			return empList.stream().filter(emp -> emp.geteNumber() > 1000).collect(Collectors.toList());
		}, executor).thenApplyAsync((empList) -> {
			biCon.accept("In Name Contains S : ", Thread.currentThread().getName());
			return empList.stream().filter(i -> i.getfName().contains("S")).collect(Collectors.toList());
		}, executor).thenApplyAsync((emp) -> {
			biCon.accept("In PinCode : ", Thread.currentThread().getName());
			return emp.stream().filter(i -> i.getePincode() > 500000).collect(Collectors.toList());
		}, executor).thenAcceptAsync((nameList) -> {
			biCon.accept("In Print: ", Thread.currentThread().getName());
			System.out.println("Final Records "+nameList.size()+" out of "+noOfRec+" Records"+"\n");
			nameList.stream().limit(10).forEach(ProcessEmployeeData::printName);
		}, executor)

		;
//		executor.shutdown();
		return voidCompletableFuture;
	}// process()

	public static void printName(Employee emp) {
//		System.out.println(emp.getfName() + ", ");
		System.out.println(emp.toString());
	}
}
