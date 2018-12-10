package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.BankUtil;
import com.revature.util.ConnectionUtil;

public class GoToTheBank extends BankUtil {

	public static void main(String[] args) {
		init();
		User us = new User(0, null, null);
		Account ac = new Account(0, 0, us, null, null);
		String action = "";
		double deposit = 0.0;
		double withdraw = 0.0;
	
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method. 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is you user ID? ");
		us.setId(scan.nextInt());
		System.out.println("What is you first name? ");
		us.setFirstName(scan.nextLine());
		System.out.println("What is your last name? ");
		us.setLastName(scan.nextLine());
		
		System.out.println("Would you like to view your account, withdraw money, or deposit money?");
		action = scan.nextLine();
		
		switch (action){
			case "view" :
				viewAccountsByUser(us);
				break;
			case "withdraw" :
				System.out.print("How much would you like to withdraw: ");
				withdraw = scan.nextDouble();
				withdrawMoney(ac, withdraw);
				break;
				
			case "deposit" :
		}
	}
	
	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch(SQLException e)
		{
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}