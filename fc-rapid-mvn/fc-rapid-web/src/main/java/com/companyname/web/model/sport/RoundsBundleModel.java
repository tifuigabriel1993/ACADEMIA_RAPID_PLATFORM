package com.companyname.web.model.sport;

public class RoundsBundleModel {

	private Integer roundsNumber;

	private LeagueModel league;

	public Integer getRoundsNumber() {
		return roundsNumber;
	}

	public void setRoundsNumber(Integer roundsNumber) {
		this.roundsNumber = roundsNumber;
	}

	public LeagueModel getLeague() {
		return league;
	}

	public void setLeague(LeagueModel league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "RoundsBundleModel [roundsNumber=" + roundsNumber + ", league=" + league + "]";
	}

}
