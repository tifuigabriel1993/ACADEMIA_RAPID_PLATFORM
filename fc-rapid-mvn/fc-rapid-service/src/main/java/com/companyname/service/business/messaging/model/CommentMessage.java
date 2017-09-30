package com.companyname.service.business.messaging.model;

public class CommentMessage extends Message {

	private static final long serialVersionUID = 7119504483774253610L;

	private String text;

	private String userPhotoUrl;

	public CommentMessage(String url, String username) {
		super(url, username);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}

	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}

}
