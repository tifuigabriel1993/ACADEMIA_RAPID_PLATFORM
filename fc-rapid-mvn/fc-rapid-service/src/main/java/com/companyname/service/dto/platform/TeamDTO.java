package com.companyname.service.dto.platform;

import java.io.Serializable;

import com.companyname.service.dto.sport.LeagueDTO;

public class TeamDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer teamId;

	private String teamName;

	private String logoUrl;

	private LeagueDTO leagueDto;

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

	public LeagueDTO getLeagueDto() {
		return leagueDto;
	}

	public void setLeagueDto(LeagueDTO leagueDto) {
		this.leagueDto = leagueDto;
	}

	@Override
	public String toString() {
		return "TeamDTO [teamId=" + teamId + ", teamName=" + teamName + ", logoUrl=" + logoUrl + ", leagueDto="
				+ leagueDto + "]";
	}

}
