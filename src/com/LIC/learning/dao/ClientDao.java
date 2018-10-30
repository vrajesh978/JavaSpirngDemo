package com.LIC.learning.dao;

import java.sql.SQLException;
import java.util.List;

import com.LIC.learning.model.Client;

public interface ClientDao {
	public Client save(Client client) throws SQLException;

	public List<Client> getAllRegisteredClient() throws SQLException;

	public Client getClientById(long id) throws SQLException;

	public long delete(long id) throws SQLException;

	public List<Client> search(String searchQuery) throws SQLException;
}
