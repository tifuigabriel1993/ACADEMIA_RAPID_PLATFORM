package com.companyname.service.dto.social;

public class RegisterActivityDTO extends SimpleActivityDTO {

	private static final long serialVersionUID = -5721757560348462162L;

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "RegisterActivityDTO [username=" + username + "]";
	}

}
