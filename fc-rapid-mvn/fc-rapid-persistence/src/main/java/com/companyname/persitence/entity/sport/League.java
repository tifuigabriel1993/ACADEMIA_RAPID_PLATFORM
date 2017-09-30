package com.companyname.persitence.entity.sport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "leagues", uniqueConstraints = { @UniqueConstraint(columnNames = { "league_name", "country" }) })
public class League {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "league_id")
	private Integer leagueId;

	@Column(name = "league_name")
	private String leagueName;

	private String country;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "team_league", joinColumns = { @JoinColumn(name = "league_id") }, inverseJoinColumns = {
			@JoinColumn(name = "team_id") })
	private List<Team> teams = new ArrayList<>();

	@OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
	private List<Round> rounds = new ArrayList<>();

	public Integer getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

}
