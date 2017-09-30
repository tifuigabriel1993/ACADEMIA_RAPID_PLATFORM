package com.companyname.service.business.messaging.model;

import java.io.Serializable;

public abstract class Message implements Serializable {

	private static final long serialVersionUID = -4521952504400346208L;

	private String url;

	private String username;

	private String date;

	public Message(String url, String username) {
		this.url = url;
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
