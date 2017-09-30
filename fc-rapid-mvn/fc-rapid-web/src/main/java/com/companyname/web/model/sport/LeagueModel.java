package com.companyname.web.model.sport;

public class LeagueModel {

	private Integer leagueId;

	private String country;

	private String leagueName;

	public Integer getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	@Override
	public String toString() {
		return "LeagueModel [leagueId=" + leagueId + ", country=" + country + ", leagueName=" + leagueName + "]";
	}

}
