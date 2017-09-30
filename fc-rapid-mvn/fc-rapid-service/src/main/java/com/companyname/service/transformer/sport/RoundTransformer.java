package com.companyname.service.transformer.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.sport.Round;
import com.companyname.service.dto.sport.RoundDTO;

@Component
public class RoundTransformer {

	@Autowired
	private LeagueTransformer leagueTransformer;

	public Round toEntity(RoundDTO roundDto) {
		Round round = new Round();
		round.setRoundId(roundDto.getRoundId());
		round.setRoundNumber(roundDto.getRoundNumber());
		round.setLeague(leagueTransformer.toEntity(roundDto.getLeagueDto()));
		return round;
	}

	public RoundDTO toDto(Round round) {
		RoundDTO roundDto = new RoundDTO();
		roundDto.setRoundId(round.getRoundId());
		roundDto.setRoundNumber(round.getRoundNumber());
		roundDto.setLeagueDto(leagueTransformer.toDto(round.getLeague()));
		return roundDto;
	}

	public List<RoundDTO> toDtoList(List<Round> rounds) {
		List<RoundDTO> roundListDto = new ArrayList<RoundDTO>();
		rounds.forEach((k) -> roundListDto.add(toDto(k)));
		return roundListDto;
	}

}