package com.LIC.learning.service;

import java.sql.SQLException;
import java.util.List;

import com.LIC.learning.model.Client;

public interface ClientService {
	public Client save(Client client) throws SQLException;

	public List<Client> getAllRecords() throws SQLException;

	public Client getClientById(Long id) throws SQLException;

	public Long delete(long id) throws SQLException;

	public List<Client> search(String searchQuery) throws SQLException;
}
