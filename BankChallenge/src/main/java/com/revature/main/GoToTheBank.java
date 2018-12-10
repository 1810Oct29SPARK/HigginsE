package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;
import com.revature.dao.BankDAOImpl;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
	
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method.
		BankDAOImpl bd = new BankDAOImpl();
		User users = bd.getUserByID(1);
		
		System.out.println(users);
		

//				init();
	}
	
	static void init() {
        try {
            Connection con = ConnectionUtil.getConnection("connection.properties");
            System.out.println(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
