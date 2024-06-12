package com.prac.core.practice.stream.employee;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@ToString.Include(name="First Name")
    private String fName;
	
	@ToString.Include(name="Last Name")
    private String lName;
	
	@ToString.Include(name="EmployeeID")
    private int eNumber;
	
	@ToString.Include(name="Salary")
    private float eSal;
	
	@ToString.Include(name="PinCode")
    private int ePincode;
	
	@ToString.Include(name="Department Name")
    private String deptCode;
	
	@ToString.Include(name="Date_Of_Join")
    private LocalDate dateOfJoin;
	
	@ToString.Include(name="Gender")
    private String gender;
}
