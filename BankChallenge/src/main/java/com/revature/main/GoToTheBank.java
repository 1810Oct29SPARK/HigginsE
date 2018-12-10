package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {
	
		public static void main(String[] args) {
			init();
			AccountDAO bd = new AccountDAOImpl();
			//List<Account> Accounts = bd.getAccounts();
			//for(Account b : Accounts) {
				System.out.println(bd.getAccountById(1));
			//}
			bd.getAccount(1);
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
