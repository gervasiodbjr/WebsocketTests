package com.gervasio.websockettest.beans;

public class Chat {
	
	private String user;
	private String message;
	private String uuid;
	
	
	public Chat() {}
	
	public Chat(String user) {
		this.setUser(user);
	}
	
	public Chat(String user, String uuid) {
		this.setUser(user);
		this.setUuid(uuid);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
