package org.chatlogs.chatlogs.model;

import javax.json.bind.annotation.JsonbTransient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	private String message;
	private long timestamp;
	private boolean isSent;
	@JsonbTransient
	@Column(length = 16)
	private String userId;

	public Message(int messageId, String message, long timestamp, boolean isSent, String userId) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.timestamp = timestamp;
		this.isSent = isSent;
		this.userId = userId;
	}

	public Message() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", timestamp=" + timestamp + ", isSent="
				+ isSent + "]";
	}
}
