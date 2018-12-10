package com.revature.dao;

public interface AccountDAO {

	//define necessary CRUD methods and build an implementing class in this package
	public void insertAccount(int id, int number, String user, String name, int balance, int userid) ;
	public void getAccount(int id, int number, String user, String name, int balance) ;

	public void deleteAccount(String first);
	
	
}