package org.chatlogs.chatlogs.dao;

import java.util.List;

import org.chatlogs.chatlogs.dao.session.SessionUtils;
import org.chatlogs.chatlogs.model.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MessageDao {

	public Message addMessageForUser(Message message) {
		Session session = SessionUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(message);
		transaction.commit();
		SessionUtils.close();
		return message;
	}

	public List<Message> getMessagesForUser(String userId, int start, int limit) {
		Session session = SessionUtils.getSession();
		Query<Message> query = session.createQuery("from Message as m where m.userId=:userId");
		query.setFirstResult(start);
		query.setMaxResults(limit);
		query.setParameter("userId", userId);
		List<Message> list = query.list();
		SessionUtils.close();
		return list;
	}
	

	public List<Message> getMessagesForUser(String userId) {
		Session session = SessionUtils.getSession();
		Query<Message> query = session.createQuery("from Message as m where m.userId=:userId");
		query.setParameter("userId", userId);
		List<Message> list = query.list();
		SessionUtils.close();
		return list;
	}

	public int deleteAllMessagesForUser(String userId) {
		Session session = SessionUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from Message m where m.userId=:userId");
		query.setParameter("userId", userId);
		int response = query.executeUpdate();
		transaction.commit();
		SessionUtils.close();
		return response;
	}
	
	public int deleteMessageForUser(String userId,int messageId) {
		Session session = SessionUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from Message m where m.userId=:userId and m.messageId=:messageId");
		query.setParameter("userId", userId);
		query.setParameter("messageId", messageId);
		int response = query.executeUpdate();
		transaction.commit();
		SessionUtils.close();
		return response;
	}

}
