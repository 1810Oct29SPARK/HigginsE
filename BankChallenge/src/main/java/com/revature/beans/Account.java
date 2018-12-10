package com.revature.beans;

public class Account {
	
	public Account(int id, short accountNumber, int userID, String accountName, Double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		//this.user = user;
		this.userID=userID;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public Account()
	{
		
	}
	
	private int id;
	private short accountNumber;
	//private User user; //could also implement as integer primary key
	private int userID;
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
		return userID;
	}
	public void setUser(int userID) {
		this.userID = userID;
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
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", user=" + userID + ", accountName="
				+ accountName + ", balance=" + balance + "]";
	}

}
