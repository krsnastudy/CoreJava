package com.prac.core.problem.equal;

public class User {

	private String userName;
	private String password;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		// return Objects.hash(password, userName);
		return super.hashCode();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
