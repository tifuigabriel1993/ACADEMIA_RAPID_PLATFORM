package com.companyname.service.business.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.sport.LeagueRepository;
import com.companyname.integration.repository.sport.TeamRepository;
import com.companyname.persitence.entity.sport.League;
import com.companyname.persitence.entity.sport.Team;
import com.companyname.service.dto.platform.TeamDTO;
import com.companyname.service.exception.LeagueNotFound;
import com.companyname.service.transformer.sport.TeamTransformer;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private TeamTransformer teamTransformer;

	@Override
	public void addTeam(TeamDTO teamDto) {
		Team team = teamTransformer.toEntity(teamDto);

		League league = leagueRepository.findOne(teamDto.getLeagueDto().getLeagueId());
		if (league == null) {
			throw new LeagueNotFound();
		}

		team.getLeagues().add(league);
		league.getTeams().add(team);
		teamRepository.save(team);
	}

	@Override
	public List<TeamDTO> findAllTeams() {
		return teamTransformer.toDtoList(teamRepository.findAll());
	}

}