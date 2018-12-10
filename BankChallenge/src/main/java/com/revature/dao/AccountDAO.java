package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {
    public List<Account> getAccount(int i);
    public Account getAccountById(int id);
}
