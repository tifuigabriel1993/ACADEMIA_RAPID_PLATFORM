package com.companyname.service.dto.platform;

import java.io.Serializable;
import java.util.List;

import com.companyname.service.dto.sport.StadiumDTO;
import com.companyname.service.dto.sport.TicketDTO;

public class MatchDTO implements Serializable {

	private static final long serialVersionUID = 39828231944362188L;

	private Long matchId;

	private TeamDTO homeTeam;;

	private TeamDTO awayTeam;

	private Integer homeTeamGoals;

	private Integer awayTeamGoals;

	private StadiumDTO stadium;

	private List<TicketDTO> tickets;

	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public TeamDTO getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamDTO homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamDTO getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamDTO awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Integer getHomeTeamGoals() {
		return homeTeamGoals;
	}

	public void setHomeTeamGoals(Integer homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public Integer getAwayTeamGoals() {
		return awayTeamGoals;
	}

	public void setAwayTeamGoals(Integer awayTeamGoals) {
		this.awayTeamGoals = awayTeamGoals;
	}

	public StadiumDTO getStadium() {
		return stadium;
	}

	public void setStadium(StadiumDTO stadium) {
		this.stadium = stadium;
	}

	public List<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "MatchDTO [matchId=" + matchId + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeTeamGoals="
				+ homeTeamGoals + ", awayTeamGoals=" + awayTeamGoals + ", stadium=" + stadium + ", tickets=" + tickets
				+ "]";
	}

}