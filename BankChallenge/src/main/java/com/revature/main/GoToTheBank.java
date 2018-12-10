package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
		init();
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method. 

	}
	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connections.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}