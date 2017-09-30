package com.companyname.persitence.entity.platform;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private long roleId;

	private String name;

	//bi-directional many-to-many association to Authorisation
	@ManyToMany
	@JoinTable(
		name="role_auths"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="auth_id")
			}
		)
	private Set<Authorization> authorizations;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private Set<User> users;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Authorization> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(Set<Authorization> authorizations) {
		this.authorizations = authorizations;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}