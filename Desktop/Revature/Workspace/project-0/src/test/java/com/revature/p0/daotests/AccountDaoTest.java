package com.revature.p0.daotests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.p0.daos.AccountDAO;
import com.revature.p0.daos.AccountDAOPost;
import com.revature.p0.daos.ClientDAO;
import com.revature.p0.daos.ClientDAOPost;
import com.revature.p0.entities.Account;
import com.revature.p0.entities.Client;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTest {
	private static AccountDAO adao = new AccountDAOPost();
    private static ClientDAO cdao = new ClientDAOPost();
    private static Client testClient = null;
    private static Account testAccount = null;

    @BeforeAll
    public static void setUpOnce() {
        System.out.println("Set Up Once");
        Client c1 = new Client(0, "Harry Potter");
        testClient = cdao.createClient(c1);
    }

    @Test
    @Order(1)
    void create_account() {
        // ID of zero means object has not been saved/persisted.
        Account account = new Account(0, 1000, testClient.getId());
        adao.createAccount(account);
        testAccount = account;
        Assertions.assertNotEquals(0, testAccount.getId());
    }

    @Test
    @Order(2)
    void get_account_by_id() {
        int id = testAccount.getId();
        Account account = adao.getAccountById(id);
        Assertions.assertEquals(testAccount.getId(), account.getId());
    }
}
