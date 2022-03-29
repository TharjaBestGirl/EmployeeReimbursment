package com.revature.p0.service;


import io.javalin.http.BadRequestResponse;

import java.util.HashSet;
import java.util.Set;

import com.revature.p0.daos.AccountDAO;
import com.revature.p0.daos.ClientDAO;
import com.revature.p0.daos.ClientDAOPost;
import com.revature.p0.entities.Account;
import com.revature.p0.entities.Client;
import com.revature.p0.exceptions.BadRequestException;
import com.revature.p0.exceptions.NotFoundException;

public class AccountServicePost implements AccountService {

    private AccountDAO dao;
    private ClientDAO cDao;

    // Dependency injection.
    // A service is created by passing in the dependency it needs.
    public AccountServicePost(AccountDAO dao) {
        this.dao = dao;
        this.cDao = new ClientDAOPost();
    }

    @Override
    public Account createAccount(Account account) {
        // Check if client exists (throws NotFoundException if not found)
        this.cDao.getClientById(account.getClientId());
        // Check if account number already exists.
        Set<Account> allAccounts = this.dao.getAllAccounts(account.getClientId());
        for (Account a : allAccounts) {
            if (a.getId() == account.getId()) {
                throw new BadRequestException("Account number already exists");
            }
        }
        Account newAccount = this.dao.createAccount(account);
        return newAccount;
    }

    @Override
    public Set<Account> getAllAccounts(int clientId) {
        // Check if client exists.
        Client client = this.cDao.getClientById(clientId);
        // Filter accounts to the respective client.
        Set<Account> allAccounts = this.dao.getAllAccounts(client.getId());
        Set<Account> selectedAccounts = new HashSet<>();
        for (Account a : allAccounts) {
            if (a.getClientId() == client.getId()) {
                selectedAccounts.add(a);
            }
        }
        return selectedAccounts;
    }

    @Override
    public Account getAccountById(int clientId, int id) {
        // Check if client exists.
        Client client = this.cDao.getClientById(clientId);
        Account account = this.dao.getAccountById(id);
        if (account.getClientId() != client.getId()) {
            throw new NotFoundException("No such account exists");
        }
        return account;
    }
}
