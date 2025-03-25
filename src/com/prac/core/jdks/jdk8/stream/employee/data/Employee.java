package com.prac.core.jdks.jdk8.stream.employee.data;

import com.prac.core.jdks.jdk8.stream.employee.data.Department.DepartmentCode;

public class Employee {

	private String fName;
	private String lName;
	private int eNumber;
	private float eSal;
	private int ePincode;
	private DepartmentCode department;
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, int eNumber, float eSal, int ePincode, DepartmentCode department) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.eNumber = eNumber;
		this.eSal = eSal;
		this.ePincode = ePincode;
		this.department = department;
	}
	
	public Employee(Employee e) {
		super();
		this.fName = e.fName;
		this.lName = e.lName;
		this.eNumber = e.eNumber;
		this.eSal = e.eSal;
		this.ePincode = e.ePincode;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [FirstName=" + fName + ", LastName=" + lName + ", EmpNo=" + eNumber + ", Salary=" + eSal
				+ ", Pincode=" + ePincode + ", Department=" + department + "]";
	}

	public String toStringSpecific() {
		return "{EmpNo: "+ eNumber 
				+ ", EmpName: " + (fName +", "+ lName) 
				+ ", EmpSal: " + eSal
				+  "}";
	}
	
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the eNumber
	 */
	public int geteNumber() {
		return eNumber;
	}
	/**
	 * @param eNumber the eNumber to set
	 */
	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
	/**
	 * @return the eSal
	 */
	public float geteSal() {
		return eSal;
	}
	/**
	 * @param eSal the eSal to set
	 */
	public void seteSal(float eSal) {
		this.eSal = eSal;
	}
	/**
	 * @return the ePincode
	 */
	public int getePincode() {
		return ePincode;
	}
	/**
	 * @param ePincode the ePincode to set
	 */
	public void setePincode(int ePincode) {
		this.ePincode = ePincode;
	}
	
	public DepartmentCode getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentCode department) {
		this.department = department;
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + eNumber; result = prime * result + ePincode; result
	 * = prime * result + Float.floatToIntBits(eSal); result = prime * result +
	 * ((fName == null) ? 0 : fName.hashCode()); result = prime * result + ((lName
	 * == null) ? 0 : lName.hashCode()); return result; }
	 */

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Employee other = (Employee) obj; if (eNumber != other.eNumber) return
	 * false; if (ePincode != other.ePincode) return false; if
	 * (Float.floatToIntBits(eSal) != Float.floatToIntBits(other.eSal)) return
	 * false; if (fName == null) { if (other.fName != null) return false; } else if
	 * (!fName.equals(other.fName)) return false; if (lName == null) { if
	 * (other.lName != null) return false; } else if (!lName.equals(other.lName))
	 * return false; return true; }
	 */
	
	/*
	 @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return ((Employee) obj).eNumber == eNumber;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.eNumber;
    }
	 */
	
}
