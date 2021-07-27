package com.prac.core.jdk5.design.builder;

public class BankAccount {
	private long accountNumber; // This is important, so we'll pass it to the constructor.
	private String owner;
	private String branch;
	private double balance;
	private double interestRate;

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", owner=" + owner + ", branch=" + branch + ", balance="
				+ balance + ", interestRate=" + interestRate + "]";
	}

	public BankAccount(long accountNumber, String owner, String branch, double balance, double interestRate) {
		super();
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.branch = branch;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public BankAccount() {
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public String getBranch() {
		return branch;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public static class builder {

		private long accountNumber; // This is important, so we'll pass it to the constructor.
		private String owner;
		private String branch;
		private double balance;
		private double interestRate;

		public builder(long accountNumber) {
			this.accountNumber = accountNumber;
		}

		public builder withOwner(String owner) {
			this.owner = owner;

			return this; // By returning the builder each time, we can create a fluent interface.
		}

		public builder atBranch(String branch) {
			this.branch = branch;

			return this;
		}

		public builder openingBalance(double balance) {
			this.balance = balance;

			return this;
		}

		public builder atRate(double interestRate) {
			this.interestRate = interestRate;

			return this;
		}

		public BankAccount build() {
			// Here we create the actual bank account object, which is always in a fully
			// initialised state when it's returned.
			BankAccount account = new BankAccount(); // Since the builder is in the BankAccount class, we can invoke its
														// private constructor.
			account.accountNumber = this.accountNumber;
			account.owner = this.owner;
			account.branch = this.branch;
			account.balance = this.balance;
			account.interestRate = this.interestRate;

			return account;
		}
	}

}