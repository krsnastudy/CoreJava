package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import com.prac.core.jdks.jdk11.files.FileChanges;
import com.prac.core.jdks.jdk8.stream.employee.data.Employee;
import com.prac.core.jdks.jdk8.stream.employee.data.EmployeeExt;
import com.prac.core.jdks.jdk8.stream.employee.data.PopulateEmpData;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ApplyAsyncChainOfTasksExample {
	static final int noOfRec = 1000;
	static MyThreadFactory cacheThreadFactory = new MyThreadFactory("CachedThreadPool-Thread");
	static MyThreadFactory scheduledThreadFactory = new MyThreadFactory("ScheduledThreadPool-Thread");
	static MyThreadFactory singleThreadFactory = new MyThreadFactory("SingleThreadExecutor-Thread");
	static MyThreadFactory fixedThreadFactory = new MyThreadFactory("FixedThreadPool-Thread");

	static ExecutorService fixedThreadPoolExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	static ExecutorService fixedThreadPoolExecutor1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), fixedThreadFactory);
	static ExecutorService cacheExecutor = Executors.newCachedThreadPool(cacheThreadFactory);
	static ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(), scheduledThreadFactory);
	static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(singleThreadFactory);

	@Async("asyncExecutor")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		process().get();
		shutdownExecutors();
	}

	@SneakyThrows
	@Async("asyncExecutor")
	public static CompletableFuture<Void> process() {

		BiConsumer<String, String> biCon = (stage, threadName) ->
			System.out.println("Stage :: "+stage.replace(":", "") +" & ThreadName: " + threadName);

	CompletableFuture<Void> voidCompletableFuture =
		CompletableFuture
		.supplyAsync(() -> {
			biCon.accept("fetchEmployees", Thread.currentThread().getName());
//			return EmployeeDB.fetchEmployees(noOfRec);
			List<Employee> employeeList = EmployeeDB.fetchEmployees(noOfRec);
//			employeeList.stream().forEach(i->System.out.println(i.toStringSpecific()));
			return employeeList;
		}, cacheExecutor)

		.thenApplyAsync((empList) -> {
			int salaryFilter = 25000;
			biCon.accept("Salary>"+salaryFilter, Thread.currentThread().getName());
//			System.out.println(1/0);
			return empList.stream().filter(emp -> emp.geteSal() > salaryFilter).collect(Collectors.toList());
		}, fixedThreadPoolExecutor)

		.exceptionallyAsync(exception -> {
            System.out.println("In Exceptionally Block");
            exception.printStackTrace();
//            System.err.println(exception);
            return null;
        }, fixedThreadPoolExecutor1)

		.thenApplyAsync((empList) -> {
			biCon.accept("EmployeeNumber", Thread.currentThread().getName());
			return empList.stream().filter(emp -> emp.geteNumber() > 100000).collect(Collectors.toList());
		}, scheduledExecutor)

		.thenApplyAsync((empList) -> {
			biCon.accept("Name Contains 'S'", Thread.currentThread().getName());
			return empList.stream().filter(i -> i.getfName().contains("s")).collect(Collectors.toList());
		}, singleThreadExecutor)

		.thenApplyAsync((emp) -> {
			biCon.accept("PinCode", Thread.currentThread().getName());
			return emp.stream().filter(i -> i.getePincode() > 500000).collect(Collectors.toList());
		})

		.thenApplyAsync((empSortList)->{
			biCon.accept("Sorting", Thread.currentThread().getName());
			Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getfName)
					.thenComparing(Employee::getlName)
					.thenComparing(Employee::getDepartment);
			return empSortList.stream().sorted(employeeComparator).collect(Collectors.toList());
		}, singleThreadExecutor)

		.thenAcceptAsync((nameList) -> {
			biCon.accept("Print", Thread.currentThread().getName());
			int printCount=5;
			Comparator<Employee> salComparator = Comparator.comparing(Employee::geteSal).thenComparing(Employee::getDepartment).reversed();
			System.out.println("\nFinal Records "+nameList.size()+" out of "+noOfRec+" Records [OUTPUT display restricted to "+printCount+" Records Only]");
			nameList.stream().sorted(salComparator).limit(printCount).forEach(ApplyAsyncChainOfTasksExample::printName);
		}, fixedThreadPoolExecutor1)

		.thenAcceptAsync((empList)->{
			System.out.println();
			biCon.accept("FileWrite", Thread.currentThread().getName());
			FileChanges.writeFile("empDetails.txt");
		}, fixedThreadPoolExecutor1)
	;

		return voidCompletableFuture;
	}// process()

	public static void printName(Employee emp) {
		System.out.println(emp.toString());
	}

	public static void shutdownExecutors() {
		System.out.println("shutting down all Executors");
		fixedThreadPoolExecutor.shutdown();
		fixedThreadPoolExecutor1.shutdown();
		cacheExecutor.shutdown();
		scheduledExecutor.shutdown();
		singleThreadExecutor.shutdown();
	}
}


/*
Stage :: fetchEmployees & ThreadName: CachedThreadPool-1
Stage :: Salary>25000 & ThreadName: pool-1-thread-1
Stage :: EmployeeNumber & ThreadName: ScheduledThreadPool-1
Stage :: Name Contains 'S' & ThreadName: SingleThreadExecutor-1
Stage :: PinCode & ThreadName: ForkJoinPool.commonPool-worker-1
Stage :: Sorting & ThreadName: SingleThreadExecutor-1
Stage :: Print & ThreadName: pool-2-thread-2

Final Records 212 out of 1000 Records [OUTPUT display restricted to 5 Records Only]

*/