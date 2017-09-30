package com.companyname.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.sport.RoundService;
import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.web.mapper.sport.LeagueMapper;
import com.companyname.web.model.sport.RoundsBundleModel;

@Controller
@RequestMapping("/api")
public class RoundRestController {

	@Autowired
	private RoundService roundService;

	@Autowired
	private LeagueMapper leagueMapper;

	@RequestMapping(value = "/rounds", method = RequestMethod.POST)
	public ResponseEntity<?> createRound(@RequestBody RoundsBundleModel roundsBundleModel) {
		LeagueDTO leagueDto = leagueMapper.mapDto(roundsBundleModel.getLeague());
		roundService.addRounds(leagueDto, roundsBundleModel.getRoundsNumber());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
