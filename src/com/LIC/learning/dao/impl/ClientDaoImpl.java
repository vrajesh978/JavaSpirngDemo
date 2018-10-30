package com.LIC.learning.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LIC.learning.dao.ClientDao;
import com.LIC.learning.model.Client;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Client> getAllRegisteredClient() throws SQLException {
		StringBuffer buffer = new StringBuffer("from Client");
		List<Client> clList = sessionFactory.getCurrentSession().createQuery(buffer.toString()).list();
		return clList;
	}

	public Client save(Client client) throws SQLException {
		sessionFactory.getCurrentSession().saveOrUpdate(client);
		return client;
	}

	public Client getClientById(long id) throws SQLException {
		StringBuffer buffer = new StringBuffer("from Client where id=:Id");
		Query q = sessionFactory.getCurrentSession().createQuery(buffer.toString());
		q.setParameter("Id", id);
		List<Client> clList = q.list();
		return clList.get(0);
	}

	public long delete(long id) throws SQLException {
		Client client = getClientById(id);
		sessionFactory.getCurrentSession().delete(client);
		return id;
	}

	public List<Client> search(String searchQuery) throws SQLException {
//		StringBuffer buffer = new StringBuffer("from Client c where ");
//		buffer.append("upper (c.firstName) like upper(:searchQuery) or upper (c.lastName) like upper(:searchQuery) ");
//		buffer.append("order by c.firstName,c.lastName");
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Client c "
                + "WHERE upper (c.firstName) LIKE CONCAT('%',upper(:searchQuery),'%') or "
				+ "upper (c.lastName) LIKE CONCAT('%',upper(:searchQuery),'%') order by c.firstName,c.lastName");
		query.setParameter("searchQuery", searchQuery);
		@SuppressWarnings("unchecked")
		//List<Client> clList = sessionFactory.getCurrentSession().createQuery(buffer.toString())
		//		.setParameter("searchQuery", searchQuery).list();
		List<Client> clList = query.list();
		return clList;
	}

}
