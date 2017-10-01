package com.companyname.service.dto.social;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.companyname.service.dto.platform.AddressDTO;
import com.companyname.service.dto.platform.UserDTO;

public class ProfileDTO implements Serializable {

	private static final long serialVersionUID = -3230486468935304510L;

	private Long profileId;

	private String nickName;

	private String urlPhoto;

	private Date birthDay;

	private String footballInfo;

	private String sex;

	private UserDTO userDto;

	private AddressDTO addressDto;

	private Set<SimpleActivityDTO> activities;

	private int userCommentsNumber;

	private int userPostsNumber;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getFootballInfo() {
		return footballInfo;
	}

	public void setFootballInfo(String footballInfo) {
		this.footballInfo = footballInfo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public AddressDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDTO addressDto) {
		this.addressDto = addressDto;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Set<SimpleActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(Set<SimpleActivityDTO> activities) {
		this.activities = activities;
	}

	public int getUserCommentsNumber() {
		return userCommentsNumber;
	}

	public void setUserCommentsNumber(int userCommentsNumber) {
		this.userCommentsNumber = userCommentsNumber;
	}

	public int getUserPostsNumber() {
		return userPostsNumber;
	}

	public void setUserPostsNumber(int userPostsNumber) {
		this.userPostsNumber = userPostsNumber;
	}

	@Override
	public String toString() {
		return "ProfileDTO [profileId=" + profileId + ", nickName=" + nickName + ", urlPhoto=" + urlPhoto
				+ ", birthDay=" + birthDay + ", footballInfo=" + footballInfo + ", sex=" + sex + ", userDto=" + userDto
				+ ", addressDto=" + addressDto + ", activities=" + activities + "]";
	}

}
