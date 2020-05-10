package com.prac.core.tree.binarytree;

import java.util.Map;

public class Employee {

	private Integer empId;
	private String firstName;
	private String lastName;
	private Long empSal;
	private String empCompany;
	private Long empContact;
	private String empMailId;
	private Address empAddress;
	
	public Employee(Employee e, String lName) {
		super();
		this.empId = e.empId;
		this.firstName = e.firstName;
		this.lastName = lName;
		this.empSal = e.empSal;
		this.empCompany = e.empCompany;
		this.empContact = e.empContact;
		this.empMailId = e.empMailId;
		this.empAddress = e.empAddress;
	}
	
	public Employee(Integer empId, String firstName, String lastName, Long empSal, String empCompany, Long empContact,
			String empMailId, Address empAddress) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empSal = empSal;
		this.empCompany = empCompany;
		this.empContact = empContact;
		this.empMailId = empMailId;
		this.empAddress = empAddress;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Long empSal) {
		this.empSal = empSal;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public Long getEmpContact() {
		return empContact;
	}

	public void setEmpContact(Long empContact) {
		this.empContact = empContact;
	}

	public String getEmpMailId() {
		return empMailId;
	}

	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", empSal=" + empSal
				+ ", empCompany=" + empCompany + ", empContact=" + empContact + ", empMailId=" + empMailId
				+ ", empAddress=" + empAddress.toString() + "]";
	}
	
	public void toStringEno(Employee e) {
		System.out.print( "[empId=" + empId.toString() + "]");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("Comparing: "+obj.toString());
		if (this == obj) {
			System.out.println("this == obj");
			return true;
		}
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
