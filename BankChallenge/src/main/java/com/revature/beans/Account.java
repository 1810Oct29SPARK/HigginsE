package com.revature.beans;

public class Account {
	
	public Account(int id, short accountNumber, int user, String accountName, Double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.user = user;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	private int id;
	private short accountNumber;
	private int user; //could also implement as integer primary key
	private String accountName;
	private Double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public short getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(short accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
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
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", user=" + user + ", accountName="
				+ accountName + ", balance=" + balance + "]";
	}

}
