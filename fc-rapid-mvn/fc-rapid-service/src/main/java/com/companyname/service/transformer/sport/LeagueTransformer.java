package com.companyname.service.transformer.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.sport.League;
import com.companyname.service.dto.sport.LeagueDTO;

@Component
public class LeagueTransformer {

	public League toEntity(LeagueDTO leagueDto) {
		League league = new League();
		league.setLeagueId(leagueDto.getLeagueId());
		league.setLeagueName(leagueDto.getLeagueName());
		league.setCountry(leagueDto.getCountry());
		return league;
	}

	public LeagueDTO toDto(League league) {
		LeagueDTO leagueDto = new LeagueDTO();
		leagueDto.setLeagueId(league.getLeagueId());
		leagueDto.setLeagueName(league.getLeagueName());
		leagueDto.setCountry(league.getCountry());
		return leagueDto;
	}

	public List<LeagueDTO> toDtoList(List<League> leagues) {
		List<LeagueDTO> leagueListDto = new ArrayList<LeagueDTO>();
		leagues.forEach((k) -> leagueListDto.add(toDto(k)));
		return leagueListDto;
	}

}
