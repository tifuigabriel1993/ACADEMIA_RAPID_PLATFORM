package com.companyname.service.business.sport;

import java.util.List;

import com.companyname.service.dto.sport.LeagueDTO;

public interface LeagueService {

	List<LeagueDTO> findAllLeagues();

	void createLeague(LeagueDTO leagueDto);

}
