package com.companyname.service.util.enums;

public enum SocialProvider {

	FACEBOOK("facebook");

	private final String id;

	private SocialProvider(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
