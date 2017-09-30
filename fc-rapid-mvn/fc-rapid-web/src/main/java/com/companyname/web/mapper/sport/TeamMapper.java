package com.companyname.web.mapper.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.service.dto.platform.TeamDTO;
import com.companyname.web.model.sport.TeamModel;

@Component
public class TeamMapper {

	@Autowired
	private LeagueMapper leagueMapper;

	public TeamModel mapModel(TeamDTO teamDto) {
		TeamModel teamModel = new TeamModel();
		teamModel.setTeamId(teamDto.getTeamId());
		teamModel.setLogoUrl(teamDto.getLogoUrl());
		teamModel.setTeamName(teamDto.getTeamName());
		return teamModel;
	}

	public TeamDTO mapDto(TeamModel teamModel) {
		TeamDTO teamDto = new TeamDTO();
		teamDto.setTeamId(teamModel.getTeamId());
		teamDto.setLogoUrl(teamModel.getLogoUrl());
		teamDto.setTeamName(teamModel.getTeamName());
		teamDto.setLeagueDto(leagueMapper.mapDto(teamModel.getLeague()));
		return teamDto;
	}

	public List<TeamModel> mapModelList(List<TeamDTO> teamDtos) {
		List<TeamModel> teams = new ArrayList<>();
		teamDtos.forEach((k) -> teams.add(mapModel(k)));
		return teams;
	}

}