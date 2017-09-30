package com.companyname.service.dto.sport;

import java.io.Serializable;

public class StadiumDTO implements Serializable {

	private static final long serialVersionUID = -714021921359731960L;

	private int stadiumId;

	private String name;

	private String image;

	private String location;

	public int getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "StadiumDTO [stadiumId=" + stadiumId + ", name=" + name + ", image=" + image + ", location=" + location
				+ "]";
	}

}
