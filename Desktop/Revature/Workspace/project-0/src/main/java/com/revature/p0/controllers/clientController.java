package com.revature.p0.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.utils.ConnectionUtil;
import com.revature.p0.daos.ClientDAOPost;
import com.revature.p0.entities.Client;
import com.revature.p0.service.ClientService;
import com.revature.p0.service.ClientServicePost;

import io.javalin.http.Handler;

public class clientController {
	
	static ClientService service = new ClientServicePost(new ClientDAOPost());
	public static Handler getAllClientsHandler = ctx -> {
		List<Client> cList = service.getAllClients();
		ctx.json(cList);
	};
	
	public static Handler getClientByIdHandler = ctx -> {
		int p = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtil.createConnection();
		String selectClients = "select * from clients where client_id=?";
		PreparedStatement ptsmt = conn.prepareStatement(selectClients);
		ptsmt.setInt(1, p);
		ResultSet rs = ptsmt.executeQuery();
		ArrayList<Client> cList = new ArrayList<Client>();
		Client c;
		while (rs.next()) {
			int id = rs.getInt("client_id");
			String name = rs.getString("name");
			c = new Client(id, name);
			cList.add(c);
		}
		ctx.json(cList);
		rs.close();
		ptsmt.close();
	};
	
	public static Handler createClientHandler = ctx -> {
		Client client = ctx.bodyAsClass(Client.class);
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("insert into clients values(?, ?)");
		ptsmt.setInt(1, client.getId());
		ptsmt.setString(2, client.getName());
		ptsmt.execute();
		ctx.status(201);
		ptsmt.close();
	};
	
	public static Handler updateClientHandler = ctx -> {
		int p = Integer.parseInt(ctx.pathParam("id"));
		Client c1 = ctx.bodyAsClass(Client.class);
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("update clients set name = ? where client_id = ?");
		ptsmt.setString(1, c1.getName());
		ptsmt.setInt(2, p);
		ptsmt.execute();
		ctx.status(200);
		ptsmt.close();
	};
	
	public static Handler deleteClientHandler = ctx -> {
		int p = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement ptsmt = conn.prepareStatement("delete from clients where client_id = ?");
		ptsmt.setInt(1, p);
		ptsmt.execute();
		ctx.status(205);
	};

}
