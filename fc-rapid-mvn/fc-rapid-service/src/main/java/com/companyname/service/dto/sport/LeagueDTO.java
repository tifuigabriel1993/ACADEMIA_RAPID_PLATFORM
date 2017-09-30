package com.companyname.service.dto.sport;

import java.io.Serializable;

public class LeagueDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer leagueId;

	private String leagueName;

	private String country;

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

	@Override
	public String toString() {
		return "LeagueDTO [leagueId=" + leagueId + ", leagueName=" + leagueName + ", country=" + country + "]";
	}

}
