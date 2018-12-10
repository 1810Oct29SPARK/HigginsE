package com.revature.beans;

public class Account {

	public Account(int accountNumber, String accountName, Double balance) {
		super();
		this.setAccountNumber(accountNumber);
		this.accountName = accountName;
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// private int id;
//	private short accountNumber;
	private int accountNumber; // could also implement as integer primary key
	private String accountName;
	private Double balance;

}
