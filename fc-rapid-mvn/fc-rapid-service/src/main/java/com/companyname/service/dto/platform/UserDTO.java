package com.companyname.service.dto.platform;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer userId;

	protected String facebookId;

	@Pattern(regexp = "[a-zA-z]([a-zA-z0-9]){5,20}", message="Username-ul poate contine doar litere si cifre !")
	protected String username;

	@Pattern(regexp = "[a-zA-z]{2,20}", message="Numele trebuie sa contina doar litere !")
	protected String firstName;

	@Pattern(regexp = "[a-zA-z]{2,20}", message="Prenumele trebuie sa contina doar litere !")
	protected String secondName;

	@Pattern(regexp="[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+", message="Adresa de email invalida !")
	protected String email;

	@Length(min = 6, max = 20, message="{Parola trebuie sa contina minim 6 caractere.}")
	protected String password;

	private String profilePhotoUrl;

	private boolean socialUser;
	
	protected String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSocialUser() {
		return socialUser;
	}

	public void setSocialUser(boolean socialUser) {
		this.socialUser = socialUser;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", facebookId=" + facebookId + ", username=" + username + ", firstName="
				+ firstName + ", secondName=" + secondName + ", email=" + email + ", password=" + password
				+ ", profilePhotoUrl=" + profilePhotoUrl + ", socialUser=" + socialUser + "]";
	}

}