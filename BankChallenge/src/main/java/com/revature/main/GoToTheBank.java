package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.BankUtil;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
	BankUtil test=new BankUtil();
	test.getAccountById(1);
		

//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method. 

	}
}