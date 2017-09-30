package com.companyname.persitence.entity.platform;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "authorizations")
@NamedQuery(name = "Authorizations.findAll", query = "SELECT a FROM Authorization a")
public class Authorization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auth_id")
	private long authId;

	private String name;

	// bi-directional many-to-many association to Role
	@ManyToMany(mappedBy = "authorizations")
	private Set<Role> roles;

	public Authorization() {
	}

	public long getAuthId() {
		return this.authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}