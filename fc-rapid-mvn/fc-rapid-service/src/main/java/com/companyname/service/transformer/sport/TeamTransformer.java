package com.companyname.service.transformer.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.sport.Team;
import com.companyname.service.dto.platform.TeamDTO;

@Component
public class TeamTransformer {

	public Team toEntity(TeamDTO teamDto) {
		Team team = new Team();
		team.setTeamId(teamDto.getTeamId());
		team.setName(teamDto.getTeamName());
		team.setLogoUrl(teamDto.getLogoUrl());
		return team;
	}

	public TeamDTO toDto(Team team) {
		TeamDTO teamDto = new TeamDTO();
		teamDto.setTeamId(teamDto.getTeamId());
		teamDto.setTeamName(team.getName());
		teamDto.setLogoUrl(team.getLogoUrl());
		return teamDto;
	}

	public List<TeamDTO> toDtoList(List<Team> teams) {
		List<TeamDTO> teamListDto = new ArrayList<>();
		teams.forEach((k) -> teamListDto.add(toDto(k)));
		return teamListDto;
	}

}
