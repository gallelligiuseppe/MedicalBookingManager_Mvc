package it.mbm.components;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -5669286044408430375L;
	private String message;
	private MessageLevelEnum level;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageLevelEnum getLevel() {
		return level;
	}

	public void setLevel(MessageLevelEnum level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", level=" + level + "]";
	}

}
