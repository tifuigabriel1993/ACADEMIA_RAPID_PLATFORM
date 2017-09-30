package com.companyname.persitence.entity.sport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "team_id")
	private Integer teamId;

	@Column(unique = true)
	private String name;

	@Column(name = "logo_url")
	private String logoUrl;

	@ManyToMany(mappedBy = "teams", cascade = CascadeType.MERGE)
	private List<League> leagues = new ArrayList<>();

	@OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
	private List<Match> homeMatches;

	@OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL)
	private List<Match> awayMatches;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	public List<Match> getHomeMatches() {
		return homeMatches;
	}

	public void setHomeMatches(List<Match> homeMatches) {
		this.homeMatches = homeMatches;
	}

	public List<Match> getAwayMatches() {
		return awayMatches;
	}

	public void setAwayMatches(List<Match> awayMatches) {
		this.awayMatches = awayMatches;
	}

}