package com.revature.p0.service;



import java.util.Set;

import com.revature.p0.entities.Account;

public interface AccountService {
    // CREATE
    Account createAccount(Account account);

    // READ
    Set<Account> getAllAccounts(int clientId);
    Account getAccountById(int clientId, int id);
}
