package com.revature.p0.service;

import java.util.List;

import com.revature.p0.entities.Client;

public interface ClientService {
	List<Client> getAllClients();
	
	Client registerClient(Client client);
	
	Client getClientById(int id);
	
	Client updateClient(Client client);

    boolean deleteClientById(int id);
}
