package com.prac.core.jdk8.stream.employee.data;

import com.prac.core.jdk8.stream.employee.data.Department.DepartmentCode;
import com.prac.core.jdk8.stream.employee.data.Gender.GenderCode;

public class EmployeeExt extends Employee {

	private String fName;
	private String lName;
	private int eNumber;
	private float eSal;
	private int ePincode;
	private DepartmentCode department;
	private int empAge;
	private GenderCode empGender;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int geteNumber() {
		return eNumber;
	}

	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}

	public float geteSal() {
		return eSal;
	}

	public void seteSal(float eSal) {
		this.eSal = eSal;
	}

	public int getePincode() {
		return ePincode;
	}

	public void setePincode(int ePincode) {
		this.ePincode = ePincode;
	}

	public DepartmentCode getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentCode department) {
		this.department = department;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public GenderCode getEmpGender() {
		return empGender;
	}

	public void setEmpGender(GenderCode empGender) {
		this.empGender = empGender;
	}

	public EmployeeExt(String fName, String lName, int eNumber, float eSal, int ePincode, DepartmentCode department,
			int empAge, GenderCode empGender) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.eNumber = eNumber;
		this.eSal = eSal;
		this.ePincode = ePincode;
		this.department = department;
		this.empAge = empAge;
		this.empGender = empGender;
	}

	public EmployeeExt(Employee e, int empAge, GenderCode empGender) {
		super();
		this.fName = e.getfName();
		this.lName = e.getlName();
		this.eNumber = e.geteNumber();
		this.eSal = e.geteSal();
		this.ePincode = e.getePincode();
		this.department = e.getDepartment();
		this.empAge = empAge;
		this.empGender = empGender;
	}

	@Override
	public String toString() {
		return "EmployeeExt [fName=" + fName + ", lName=" + lName + ", eNumber=" + eNumber + ", eSal=" + eSal
				+ ", ePincode=" + ePincode + ", department=" + department + ", empAge=" + empAge + ", empGender="
				+ empGender + "]";
	}
	
	public String toStringSpecific() {
		return "{EmpNo: "+ eNumber 
				+ ", EmpName: " + (fName +", "+ lName) 
				+ ", EmpSal: " + eSal
				+ ", EmpGender: " + empGender
				+  "}";
	}
}
