package com.revature.p0.daos;

import java.sql.*;
import java.util.ArrayList;
import com.revature.p0.entities.Client;
import com.revature.p0.exceptions.NotFoundException;
import com.revature.p0.utils.ConnectionUtil;

public class ClientDAOPost implements ClientDAO{
	
	@Override
	public ArrayList<Client> getAllClients() {
		
		try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM clients";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Client> clients = new ArrayList<Client>();

            // While there exists clients, create a new client and store the
            // information into the new client.
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                client.setName(rs.getString("name"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "INSERT INTO clients " +
                    "(name) " +
                    "VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );
            // Set the field params.
            ps.setString(1, client.getName());
            ps.execute();
            // Return the value of the generated keys.
            ResultSet rs = ps.getGeneratedKeys();
            rs.next(); // The first element.
            int key = rs.getInt("client_id");
            client.setId(key);
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Client getClientById(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "SELECT * FROM clients WHERE client_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotFoundException("No such client exists");
            }
            Client client = new Client();
            client.setId(rs.getInt("client_id"));
            client.setName(rs.getString("name"));
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "UPDATE clients " +
                    "SET name = ? " +
                    "WHERE client_id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setInt(2, client.getId());
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                throw new NotFoundException("No such client exists");
            }
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean deleteClientById(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "DELETE FROM clients WHERE client_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                throw new NotFoundException("Unable to delete: No such client exists");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
}
