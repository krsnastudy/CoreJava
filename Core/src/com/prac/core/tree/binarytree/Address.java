package com.prac.core.tree.binarytree;

public class Address {

	private String address1;
	private String address2;
	private String address3;
	private Integer pincode;
	
	public Address(String address1, String address2, String address3, Integer pincode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.pincode = pincode;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", pincode="
				+ pincode + "]";
	}
	
}
