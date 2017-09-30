package com.companyname.service.business.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.sport.LeagueRepository;
import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.service.exception.ResourceAlreadyExists;
import com.companyname.service.transformer.sport.LeagueTransformer;

@Service
public class LeagueServiceImpl implements LeagueService {

	@Autowired
	private LeagueRepository leagueRepository;

	@Autowired
	private LeagueTransformer leagueTransformer;

	@Override
	public void createLeague(LeagueDTO leagueDto) {
		try {
			leagueRepository.save(leagueTransformer.toEntity(leagueDto));
		} catch (DataIntegrityViolationException dive) {
			throw new ResourceAlreadyExists("Liga deja existenta");
		}
	}

	@Override
	public List<LeagueDTO> findAllLeagues() {
		return leagueTransformer.toDtoList(leagueRepository.findAll());
	}

}
