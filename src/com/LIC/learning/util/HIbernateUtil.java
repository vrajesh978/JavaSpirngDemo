package com.LIC.learning.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HIbernateUtil {
	public static SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		return sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		HIbernateUtil.sessionFactory = sessionFactory;
	}
}
