 package com.revature.beans;

public class Account {

	private int id;
	private short accountNumber;
	private Customer customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", customer=" + customer + ", accountName="
				+ accountName + ", balance=" + balance + "]";
	}

	public Account(int id, short accountNumber, Customer customer, String accountName, Double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.accountName = accountName;
		this.balance = balance;
	}

}
