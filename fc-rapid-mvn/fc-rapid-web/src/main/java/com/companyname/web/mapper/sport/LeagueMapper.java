package com.companyname.web.mapper.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.web.model.sport.LeagueModel;

@Component
public class LeagueMapper {

	public LeagueDTO mapDto(LeagueModel league) {
		LeagueDTO leagueDto = new LeagueDTO();
		leagueDto.setLeagueId(league.getLeagueId());
		leagueDto.setCountry(league.getCountry());
		leagueDto.setLeagueName(league.getLeagueName());
		return leagueDto;
	}

	public LeagueModel mapModel(LeagueDTO leagueDto) {
		LeagueModel leagueModel = new LeagueModel();
		leagueModel.setCountry(leagueDto.getCountry());
		leagueModel.setLeagueName(leagueDto.getLeagueName());
		leagueModel.setLeagueId(leagueDto.getLeagueId());
		return leagueModel;
	}

	public List<LeagueModel> mapModelList(List<LeagueDTO> leagueDtos) {
		List<LeagueModel> leagues = new ArrayList<LeagueModel>();
		leagueDtos.forEach((k) -> leagues.add(mapModel(k)));
		return leagues;
	}

}