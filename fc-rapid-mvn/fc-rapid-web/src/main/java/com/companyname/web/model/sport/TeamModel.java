package com.companyname.web.model.sport;

public class TeamModel {

	private Integer teamId;

	private String teamName;

	private String logoUrl;

	private LeagueModel league;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public LeagueModel getLeague() {
		return league;
	}

	public void setLeague(LeagueModel league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "TeamModel [teamId=" + teamId + ", teamName=" + teamName + ", logoUrl=" + logoUrl + ", league=" + league
				+ "]";
	}

}
