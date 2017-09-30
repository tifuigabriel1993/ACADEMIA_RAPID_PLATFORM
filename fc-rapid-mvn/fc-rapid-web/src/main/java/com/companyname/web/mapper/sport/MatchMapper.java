package com.companyname.web.mapper.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.service.dto.platform.MatchDTO;
import com.companyname.web.model.sport.MatchModel;

@Component
public class MatchMapper {

	@Autowired
	private TeamMapper teamMapper;

	@Autowired
	private StadiumMapper stadiumMapper;

	public MatchDTO mapDto(MatchModel matchModel) {
		MatchDTO matchDto = new MatchDTO();
		matchDto.setMatchId(matchModel.getMatchId());
		matchDto.setHomeTeam(teamMapper.mapDto(matchModel.getHomeTeam()));
		matchDto.setAwayTeam(teamMapper.mapDto(matchModel.getAwayTeam()));
		matchDto.setStadium(stadiumMapper.mapDto(matchModel.getStadium()));
		return matchDto;
	}

	public MatchModel mapModel(MatchDTO matchDto) {
		MatchModel matchModel = new MatchModel();

		return matchModel;
	}

	public List<MatchModel> mapModelList(List<MatchDTO> matchDtos) {
		List<MatchModel> matches = new ArrayList<>();
		matchDtos.forEach((k) -> matches.add(mapModel(k)));
		return matches;
	}

}
