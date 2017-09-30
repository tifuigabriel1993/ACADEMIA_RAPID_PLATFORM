package com.companyname.web.model.social;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProfileModel {

	@JsonIgnore
	private String username;

	private String photoUrl;

	private String firstName;

	private String secondName;

	private String email;

	private String nickName;

	private String birthDay;

	private String sex;

	private String footballInfo;

	private AddressModel address;

	private Set<ActivityModel> activities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFootballInfo() {
		return footballInfo;
	}

	public void setFootballInfo(String footballInfo) {
		this.footballInfo = footballInfo;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public Set<ActivityModel> getActivities() {
		return activities;
	}

	public void setActivities(Set<ActivityModel> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "ProfileModel [username=" + username + ", photoUrl=" + photoUrl + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", email=" + email + ", nickName=" + nickName + ", birthDay="
				+ birthDay + ", sex=" + sex + ", footballInfo=" + footballInfo + ", address=" + address
				+ ", activities=" + activities + "]";
	}

}