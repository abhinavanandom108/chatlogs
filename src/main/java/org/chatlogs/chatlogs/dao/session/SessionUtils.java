package org.chatlogs.chatlogs.dao.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtils {
	private static SessionFactory sessionFactory;
	private static Session session;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		return session;
	}
	
	public static void close() {
		session.close();
		sessionFactory.close();
	}
}
