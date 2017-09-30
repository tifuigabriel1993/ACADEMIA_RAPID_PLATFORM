package com.companyname.web.model.sport;

import java.util.Date;
import java.util.List;

import com.companyname.persitence.entity.sport.Round;
import com.companyname.persitence.entity.sport.Ticket;

public class MatchModel {

	private Long matchId;

	private TeamModel homeTeam;

	private TeamModel awayTeam;

	private int homeTeamGoals;

	private int awayTeamGoals;

	private StadiumModel stadium;

	private List<Ticket> tickets;

	private Round round;

	private Date startDate;

	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public TeamModel getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamModel homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamModel getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamModel awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeTeamGoals() {
		return homeTeamGoals;
	}

	public void setHomeTeamGoals(int homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public int getAwayTeamGoals() {
		return awayTeamGoals;
	}

	public void setAwayTeamGoals(int awayTeamGoals) {
		this.awayTeamGoals = awayTeamGoals;
	}

	public StadiumModel getStadium() {
		return stadium;
	}

	public void setStadium(StadiumModel stadium) {
		this.stadium = stadium;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "MatchModel [matchId=" + matchId + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", homeTeamGoals=" + homeTeamGoals + ", awayTeamGoals=" + awayTeamGoals + ", stadium=" + stadium
				+ ", tickets=" + tickets + ", round=" + round + ", startDate=" + startDate + "]";
	}

}
