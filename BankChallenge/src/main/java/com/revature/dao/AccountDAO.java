package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDAO {

    public List<Account> getAccountss();
    public Account getAccountById(int id);
    public void insertAccount(int id, short accountNumber, User user, String accountName, Double balance);
}

