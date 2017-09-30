package com.companyname.persitence.entity.social;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "addresses", uniqueConstraints = { @UniqueConstraint(columnNames = { "country", "city" }) })
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer addressId;

	private String country;

	private String city;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private List<Profile> userProfiles;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

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

	public List<Profile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<Profile> userProfiles) {
		this.userProfiles = userProfiles;
	}

}