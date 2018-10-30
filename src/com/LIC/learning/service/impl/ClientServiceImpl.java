package com.LIC.learning.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.LIC.learning.dao.ClientDao;
import com.LIC.learning.model.Client;
import com.LIC.learning.service.ClientService;

@Service("ClientService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;

	@Autowired
	public void setUserDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public Client save(Client client) throws SQLException {
		clientDao.save(client);
		return client;
	}

	public List<Client> getAllRecords() throws SQLException {
		return clientDao.getAllRegisteredClient();
	}

	public Client getClientById(Long id) throws SQLException {
		Client client = clientDao.getClientById(id);
		return client;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public Long delete(long id) throws SQLException {
		return clientDao.delete(id);
	}

	public List<Client> search(String searchQuery) throws SQLException {
		return clientDao.search(searchQuery);
	}

}
