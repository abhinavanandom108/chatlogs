package org.chatlogs.chatlogs.service;

import java.util.List;

import org.chatlogs.chatlogs.dao.MessageDao;
import org.chatlogs.chatlogs.exception.MessageNotFoundException;
import org.chatlogs.chatlogs.model.Message;

public class MessageService {
	private static final int DEFAULT_LIMIT = 10;
	MessageDao messageDao = new MessageDao();

	public Message addMessageForUser(String userId, Message message) {
		message.setUserId(userId);
		return messageDao.addMessageForUser(message);
	}

	public List<Message> getAllMessagesForUser(String userId) {
		return messageDao.getMessagesForUser(userId);
	}

	public List<Message> getAllMessagesForUser(String userId, int start) {
		return getAllMessagesForUser(userId, start, DEFAULT_LIMIT);
	}

	public List<Message> getAllMessagesForUser(String userId, int start, int limit) {
		return messageDao.getMessagesForUser(userId, start, limit);
	}

	public String deleteAllMessagesForUser(String userId) {
		return messageDao.deleteAllMessagesForUser(userId) > 0
				? "All messages for user " + userId + " deleted Successfully"
				: "No messages to delete for user " + userId;
	}

	public String deleteMessageForUser(String userId, int messageId) {
		if (messageDao.deleteMessageForUser(userId, messageId) == 0) {
			throw new MessageNotFoundException("Message with id "+messageId + " does not exists for " + userId);
		}
		return "Message with id "+messageId + " deleted for " + userId;
	}
}
