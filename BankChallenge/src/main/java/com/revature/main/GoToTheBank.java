package com.revature.main;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.util.BankUtil;

public class GoToTheBank {

	public static void main(String[] args) {
		AccountDAO ad = new BankUtil();
		User u = new User(2, "EMMA", "BANKS");
		List<Account> userAccount = ad.viewAccountsByUser(u);
		for (Account a : userAccount) {
			System.out.println(a);
		}
		
		System.out.println(ad.withdrawMoney(userAccount.get(0), 1000.00)); 
		List<Account> userAccount2 = ad.viewAccountsByUser(u);
		for (Account a : userAccount2) {
			System.out.println(a);
		}
		System.out.println(ad.depositMoney(userAccount.get(0), 500.00)); 
		List<Account> userAccount3 = ad.viewAccountsByUser(u);
		for (Account a : userAccount3) {
			System.out.println(a);
		}
	}
}
	