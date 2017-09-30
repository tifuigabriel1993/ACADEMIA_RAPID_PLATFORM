package com.companyname.service.business.sport;

import java.util.List;

import com.companyname.service.dto.platform.TeamDTO;

public interface TeamService {

	void addTeam(TeamDTO teamDto);

	List<TeamDTO> findAllTeams();

}
