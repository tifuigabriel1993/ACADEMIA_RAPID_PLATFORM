package com.companyname.web.model.platform;

import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.util.annotation.FieldMatch;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "confirmedPassword", message = "password.not.confirmed"),
	@FieldMatch(first = "email", second = "confirmedEmail", message = "email.not.confirmed") })
public class UserWrapper extends UserDTO {

	private static final long serialVersionUID = 1L;

	private String confirmedPassword;

	private String confirmedEmail;

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public String getConfirmedEmail() {
		return confirmedEmail;
	}

	public void setConfirmedEmail(String confirmedEmail) {
		this.confirmedEmail = confirmedEmail;
	}

	@Override
	public String toString() {
		return "UserWrapper [confirmedPassword=" + confirmedPassword + ", confirmedEmail=" + confirmedEmail + "]";
	}

}