package com.companyname.web.model.sport;

public class StadiumModel {

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
		return "StadiumModel [stadiumId=" + stadiumId + ", name=" + name + ", image=" + image + ", location=" + location
				+ "]";
	}

}
