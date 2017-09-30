package com.companyname.web.mapper.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.service.dto.sport.RoundDTO;
import com.companyname.web.model.sport.RoundModel;

@Component
public class RoundMapper {

	@Autowired
	private LeagueMapper leagueMapper;

	public RoundModel mapModel(RoundDTO roundDto) {
		RoundModel roundModel = new RoundModel();
		roundModel.setRoundId(roundDto.getRoundId());
		roundModel.setRoundNumber(roundDto.getRoundNumber());
		roundModel.setLeague(leagueMapper.mapModel(roundDto.getLeagueDto()));
		return roundModel;
	}

	public RoundDTO mapDto(RoundModel roundModel) {
		RoundDTO roundDto = new RoundDTO();
		roundDto.setRoundId(roundModel.getRoundId());
		roundDto.setRoundNumber(roundModel.getRoundNumber());
		roundDto.setLeagueDto(leagueMapper.mapDto(roundModel.getLeague()));
		return roundDto;
	}

	public List<RoundModel> mapModelList(List<RoundDTO> roundDtos) {
		List<RoundModel> rounds = new ArrayList<>();
		roundDtos.forEach((k) -> rounds.add(mapModel(k)));
		return rounds;
	}

}
