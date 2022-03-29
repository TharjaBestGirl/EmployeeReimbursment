package com.revature.p0.daos;

import java.util.Set;

import com.revature.p0.entities.Account;

public interface AccountDAO {
    // CREATE
    Account createAccount(Account account);

    // READ
    Set<Account> getAllAccounts(int clientId);
    Account getAccountById(int id);
}

