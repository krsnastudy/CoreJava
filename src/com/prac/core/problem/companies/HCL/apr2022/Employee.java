package com.prac.core.problem.companies.HCL.apr2022;

import java.util.Objects;

public class Employee {

    private Integer employeeId;
    private String employeeName;

    public Employee(int id, String name) {
        this.employeeId = id;
        this.employeeName = name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
    }

/*
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(employeeId, employee.employeeId) && Objects.equals(employeeName, employee.employeeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName);
	}
*/

}
