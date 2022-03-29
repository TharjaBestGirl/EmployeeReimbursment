package com.revature.p0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.p0.entities.Client;

public interface ClientDAO {
	//Create
	Client createClient(Client client);
	
	//Read
	ArrayList<Client> getAllClients();
	Client getClientById(int id);

    // UPDATE
    Client updateClient(Client client);

    // DELETE
    boolean deleteClientById(int id);
}
