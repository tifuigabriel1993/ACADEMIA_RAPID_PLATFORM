package com.companyname.service.transformer.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.sport.Match;
import com.companyname.service.dto.platform.MatchDTO;

@Component
public class MatchTransformer {

	@Autowired
	private TeamTransformer teamTransformer;

	@Autowired
	private StadiumTransformer stadiumTransformer;

	public Match toEntity(MatchDTO matchDto) {
		Match match = new Match();
		match.setHomeTeam(teamTransformer.toEntity(matchDto.getHomeTeam()));
		match.setAwayTeam(teamTransformer.toEntity(matchDto.getAwayTeam()));
		match.setHomeTeamGoals(matchDto.getHomeTeamGoals());
		match.setAwayTeamGoals(matchDto.getAwayTeamGoals());
		match.setStadium(stadiumTransformer.toEntity(matchDto.getStadium()));
		return match;
	}

}
