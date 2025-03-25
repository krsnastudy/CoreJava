package com.prac.core.jdks.jdk8.threads.completablefuture.async;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException {
		System.out.println("getEmployeeName(): "+LocalDateTime.now());
		EmployeeNames employeeNameData = EmployeeData.getEmployeeName();
		Thread.sleep(1000L); // Intentional delay
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException {
		System.out.println("getEmployeeAddress(): "+LocalDateTime.now());
		EmployeeAddresses employeeAddressData = EmployeeData.getAddresses();
		Thread.sleep(1000L); // Intentional delay
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {
		System.out.println("getEmployeePhone(): "+LocalDateTime.now());
		EmployeePhone employeePhoneData = EmployeeData.getPhoneNumbers();
		Thread.sleep(1000L); // Intentional delay
		return CompletableFuture.completedFuture(employeePhoneData);
	}

}
