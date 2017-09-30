package com.companyname.service.dto.platform;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -3863205524671655192L;

	private String country;

	private String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressDTO [country=" + country + ", city=" + city + "]";
	}

}
