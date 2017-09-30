package com.companyname.service.business.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.sport.LeagueRepository;
import com.companyname.integration.repository.sport.RoundRepository;
import com.companyname.persitence.entity.sport.League;
import com.companyname.persitence.entity.sport.Round;
import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.service.dto.sport.RoundDTO;
import com.companyname.service.transformer.sport.RoundTransformer;

@Service
public class RoundServiceImpl implements RoundService {

	@Autowired
	private RoundRepository roundRepository;

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private RoundTransformer roundTransformer;

	@Override
	public void addRounds(LeagueDTO leagueDto, int roundsNumber) {
		List<Round> rounds = new ArrayList<>();
		League league = leagueRepository.findOne(leagueDto.getLeagueId());
		for (int roundNumber = 0; roundNumber < roundsNumber; ++roundNumber) {
			Round round = new Round();
			round.setLeague(league);
			round.setRoundNumber(roundNumber);
			rounds.add(round);
		}
		roundRepository.save(rounds);
	}

	@Override
	public List<RoundDTO> findAllRounds() {
		return roundTransformer.toDtoList(roundRepository.findAll());
	}

}