package com.revature.p0.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.p0.entities.Account;
import com.revature.p0.entities.Client;
import com.revature.p0.utils.ConnectionUtil;

import io.javalin.http.Handler;

public class accountController {

	public static Handler getAllAccountsHandler;
	
	public static Handler getAccountByIdHandler = ctx -> {
		int q = Integer.parseInt(ctx.pathParam("id"));
		int p = Integer.parseInt(ctx.pathParam("aid"));
		Connection conn = ConnectionUtil.createConnection();
		String selectClients = "select * from accounts where client_id=? and account_id=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ptsmt.setInt(1, q);
		ptsmt.setInt(2, p);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Account> cList = new ArrayList<Account>();
		Account a;
		while (rs.next()) {
			int id = rs.getInt("client_id");
			//String aid = rs.getString("account_id");
			int bal = rs.getInt("balance");
			int tid = rs.getInt("account_id");
			a = new Account(id, /*aid,*/bal, tid);
			cList.add(a);
		}
		ctx.json(cList);
		rs.close();
		ptsmt.close();
	};
	
	public static Handler createAccountHandler = ctx -> {
		Account account = ctx.bodyAsClass(Account.class);
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("insert into accounts values(?, ?)");
		ptsmt.setInt(1, account.getClientId());
		ptsmt.setInt(2, account.getBalanceInCents());
		ptsmt.execute();
		ctx.status(201);
		ptsmt.close();
	};
	
	public static Handler updateAccountHandler;
	
	public static Handler deleteAccountHandler;
}
