package com.companyname.service.business.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.sport.MatchRepository;
import com.companyname.persitence.entity.sport.Match;
import com.companyname.service.dto.platform.MatchDTO;
import com.companyname.service.transformer.sport.MatchTransformer;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private MatchTransformer matchTransformer;

	@Override
	public void addMatch(MatchDTO matchDto) {
		Match match = matchTransformer.toEntity(matchDto);
		matchRepository.save(match);
	}

}
