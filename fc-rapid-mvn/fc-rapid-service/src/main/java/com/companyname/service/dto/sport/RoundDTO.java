package com.companyname.service.dto.sport;

import java.io.Serializable;

public class RoundDTO implements Serializable {

	private static final long serialVersionUID = -7704323729716479263L;

	private Integer roundId;

	private Integer roundNumber;

	private LeagueDTO leagueDto;

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

	public LeagueDTO getLeagueDto() {
		return leagueDto;
	}

	public void setLeagueDto(LeagueDTO leagueDto) {
		this.leagueDto = leagueDto;
	}

	@Override
	public String toString() {
		return "RoundDTO [roundId=" + roundId + ", roundNumber=" + roundNumber + ", leagueDto=" + leagueDto + "]";
	}

}
