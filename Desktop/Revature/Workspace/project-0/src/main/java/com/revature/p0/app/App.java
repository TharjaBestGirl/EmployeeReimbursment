package com.revature.p0.app;

import java.sql.Connection;

import com.revature.p0.controllers.accountController;
import com.revature.p0.controllers.clientController;
import com.revature.p0.controllers.accountController;
import com.revature.p0.controllers.clientController;
import com.revature.p0.utils.ConnectionUtil;

import io.javalin.Javalin;

public class App {
public static void main(String[] args) {
	Javalin app=Javalin.create().start();

    accountController accountController = new accountController();
	clientController clientController = new clientController();
    
    Connection conn = ConnectionUtil.createConnection();
	
	app.get("/", ctx -> ctx.result("Bank API Main Page"));
	
	// Returns all of the clients.
	app.get("/clients", clientController.getAllClientsHandler );
	
	
	// Returns clients by id, returns accounts under client and returns account by id
	// get client with ID 12
	app.get("/clients/{id}", clientController.getClientByIdHandler );
	//app.get("/clients/{id}/accounts", accountController.getAllAccountsHandler );
	app.get("/clients/{id}/accounts/{aid}", accountController.getAccountByIdHandler );
	
	// Creates new clients and accounts for clients
	// create new client
	app.post("/clients", clientController.createClientHandler );
	app.post("/clients/{id}/accounts/", accountController.createAccountHandler );
	
	// updates clients and accounts
	// update client 12
	app.put("/clients/{id}", clientController.updateClientHandler);
	//app.put("clients/{id}/accounts/{aid}", accountController.updateAccountHandler);
	
	// Deletes clients and accounts
	// delete client 11
	app.delete("/clients/{id}", clientController.deleteClientHandler);
	//app.delete("clients/{id}/accounts/{aid}", accountController.deleteAccountHandler);
}
}
