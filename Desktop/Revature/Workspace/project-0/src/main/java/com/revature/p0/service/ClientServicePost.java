package com.revature.p0.service;

import java.util.List;

import com.revature.p0.daos.ClientDAO;
import com.revature.p0.daos.ClientDAOPost;
import com.revature.p0.entities.Client;

public class ClientServicePost implements ClientService{
	static ClientDAO dao = new ClientDAOPost();
	
	public ClientServicePost(ClientDAO dao) {
        this.dao = dao;
    }

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return this.dao.getAllClients();
	}

	@Override
	public Client registerClient(Client client) {
		// TODO Auto-generated method stub
		return this.dao.createClient(client);
	}

	@Override
	public Client getClientById(int id) {
		// TODO Auto-generated method stub
		return this.dao.getClientById(id);
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return this.dao.updateClient(client);
	}

	@Override
	public boolean deleteClientById(int id) {
		// TODO Auto-generated method stub
		return this.dao.deleteClientById(id);
	}
}
