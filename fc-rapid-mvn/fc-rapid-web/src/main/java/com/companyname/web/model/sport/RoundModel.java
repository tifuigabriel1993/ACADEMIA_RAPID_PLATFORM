package com.companyname.web.model.sport;

public class RoundModel {

	private Integer roundId;

	private Integer roundNumber;

	private LeagueModel league;

	public Integer getRoundId() {
		return roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	public Integer getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(Integer roundNumber) {
		this.roundNumber = roundNumber;
	}

	public LeagueModel getLeague() {
		return league;
	}

	public void setLeague(LeagueModel league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "RoundModel [roundId=" + roundId + ", roundNumber=" + roundNumber + ", league=" + league + "]";
	}

}
