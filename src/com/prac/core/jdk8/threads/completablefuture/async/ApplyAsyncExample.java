package com.prac.core.jdk8.threads.completablefuture.async;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.prac.core.jdk8.stream.employee.data.Employee;

public class ApplyAsyncExample {
	static final int noOfRec = 1000;
	static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ApplyAsyncExample.process().get();
		executor.shutdown();
	}

	public static CompletableFuture<Void> process() {

		BiConsumer<String, String> biCon = (stage, threadName) -> 
			System.out.println("Stage: " + stage + " & ThreadName: " + threadName);

	CompletableFuture<Void> voidCompletableFuture =	
		CompletableFuture
		.supplyAsync(() -> {
			biCon.accept("In fetchEmployees: ", Thread.currentThread().getName());
//			return EmployeeDB.fetchEmployees(noOfRec);
			List<Employee> employeeList = EmployeeDB.fetchEmployees(noOfRec);
//			employeeList.stream().forEach(i->System.out.println(i.toStringSpecific()));
			return employeeList;
		})

		.thenApplyAsync((empList) -> {
			biCon.accept("In Salary: ", Thread.currentThread().getName());
//			System.out.println(1/0);
			return empList.stream().filter(emp -> emp.geteSal() > 25000).collect(Collectors.toList());
		}, executor)
		
		.exceptionallyAsync(exception -> {
            System.out.println("in Exceptionally Block");
            exception.printStackTrace();
//            System.err.println(exception);
            return null;
        }, executor)
		
		.thenApplyAsync((empList) -> {
			biCon.accept("In EmployeeNumber: ", Thread.currentThread().getName());
			return empList.stream().filter(emp -> emp.geteNumber() > 1000).collect(Collectors.toList());
		}, executor)
		
		.thenApplyAsync((empList) -> {
			biCon.accept("In Name Contains S : ", Thread.currentThread().getName());
			return empList.stream().filter(i -> i.getfName().contains("s")).collect(Collectors.toList());
		}, executor)
		
		.thenApplyAsync((emp) -> {
			biCon.accept("In PinCode : ", Thread.currentThread().getName());
			return emp.stream().filter(i -> i.getePincode() > 500000).collect(Collectors.toList());
		})
		
		.thenAcceptAsync((nameList) -> {
			biCon.accept("In Print: ", Thread.currentThread().getName());
			Comparator<Employee> salComparator = Comparator.comparing(Employee::geteSal).thenComparing(Employee::getDepartment).reversed();
			System.out.println("\nFinal Records "+nameList.size()+" out of "+noOfRec+" Records [OUTPUT display restricted to 10 Records Only]");
			nameList.stream().sorted(salComparator).limit(10).forEach(ApplyAsyncExample::printName);
		}, executor);
	
//		executor.shutdown();
		return voidCompletableFuture;
	}// process()

	public static void printName(Employee emp) {
//		System.out.println(emp.getfName() + ", ");
		System.out.println(emp.toString());
	}
}


/*

	static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	static ExecutorService executor1 = Executors.newFixedThreadPool(10);
	static ExecutorService executor2 = Executors.newFixedThreadPool(10);
	static ExecutorService executor3 = Executors.newFixedThreadPool(10);
	static ExecutorService executor4 = Executors.newFixedThreadPool(10);

Stage: In fetchEmployees:  & ThreadName: pool-1-thread-1
Stage: In Salary:  & ThreadName: pool-2-thread-1
Stage: In EmployeeNumber:  & ThreadName: pool-3-thread-1
Stage: In Name Contains S :  & ThreadName: pool-4-thread-1
Stage: In PinCode :  & ThreadName: pool-5-thread-1
Stage: In Print:  & ThreadName: pool-1-thread-2
Final Records 27 out of 1000 Records

*/