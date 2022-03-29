package com.revature.p0.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.revature.p0.daos.AccountDAOPost;
import com.revature.p0.daos.ClientDAOPost;
import com.revature.p0.entities.Account;
import com.revature.p0.entities.Client;
import com.revature.p0.service.AccountService;
import com.revature.p0.service.AccountServicePost;
import com.revature.p0.service.ClientService;
import com.revature.p0.service.ClientServicePost;

public class AccountTests {
    private static AccountService aserv = new AccountServicePost(new AccountDAOPost());
    private static ClientService cserv = new ClientServicePost(new ClientDAOPost());
    private static Client testClient1 = null;
    private static Client testClient2 = null;
    private static Account testAccount1 = null;
    private static Account testAccount2 = null;

    @BeforeAll
    public static void setUpOnce() {
        // Set up test resources.
        System.out.println("Set Up (one time)");
        Client c1 = new Client(0,"Harry Potter");
        Client c2 = new Client(0,"Hermoine Granger");
        testClient1 = cserv.registerClient(c1);
        testClient2 = cserv.registerClient(c2);
    }

    @Test
    @Order(1)
    void create_account() {
        Account a1 = new Account(0, 3000, testClient1.getId());
        Account a2 = new Account(0, 4000, testClient2.getId());
        testAccount1 = aserv.createAccount(a1);
        testAccount2 = aserv.createAccount(a2);

        Assertions.assertNotEquals(0, testAccount1.getId());
        Assertions.assertEquals(1, testAccount1.getId());
        Assertions.assertNotEquals(0, testAccount2.getId());
        Assertions.assertEquals(2, testAccount2.getId());
    }
}
