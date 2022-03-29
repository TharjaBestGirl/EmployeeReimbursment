package com.revature.p0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.p0.entities.Account;
import com.revature.p0.entities.Client;
import com.revature.p0.exceptions.NotFoundException;
import com.revature.p0.utils.ConnectionUtil;

public class AccountDAOPost implements AccountDAO{
	@Override
    public Account createAccount(Account account) {
        // Try with resources syntax.
        // Java will always close the object to prevent resource leaks.
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "INSERT INTO accounts " +
                    "(balance, client_id) " +
                    "VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );
            // Set the field params.
            ps.setInt(1, account.getBalanceInCents());
            ps.setInt(2, account.getClientId());
            ps.execute();
            // Return the val of the generated keys.
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("account_id");
            account.setId(key);
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM accounts WHERE client_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                throw new NotFoundException("No such account exists");
            }
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            account.setBalanceInCents(rs.getInt("balance"));
            account.setClientId(rs.getInt("client_id"));
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Set<Account> getAllAccounts(int clientId) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM accounts";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Set<Account> accounts = new HashSet<>();
            // While there exists records, create a new instance and store
            // the information into the new instance.
            while(rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("account_id"));
                account.setBalanceInCents(rs.getInt("balance"));
                account.setClientId(rs.getInt("client_id"));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}
}
