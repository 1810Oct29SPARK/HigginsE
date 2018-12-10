package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface CustomerDAO {
	
	//define necessary CRUD methods and build an implementing class in this package
	
	public Customer getCustomerById(int id);
}
