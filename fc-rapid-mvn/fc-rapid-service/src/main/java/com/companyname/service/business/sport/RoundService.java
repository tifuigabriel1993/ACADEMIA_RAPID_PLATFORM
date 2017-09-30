package com.companyname.service.business.sport;

import java.util.List;

import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.service.dto.sport.RoundDTO;

public interface RoundService {

	List<RoundDTO> findAllRounds();

	void addRounds(LeagueDTO leagueDto, int roundsNumber);

}
