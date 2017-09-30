package com.companyname.web.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.sport.LeagueService;
import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.service.exception.ResourceAlreadyExists;
import com.companyname.web.mapper.sport.LeagueMapper;
import com.companyname.web.model.platform.JsonMessage;
import com.companyname.web.model.sport.LeagueModel;

@Controller
@RequestMapping("/api")
public class LeagueRestController {

	@Autowired
	private LeagueService leagueService;

	@Autowired
	private LeagueMapper leagueMapper;

	@RequestMapping(value = "/league", method = RequestMethod.POST)
	public ResponseEntity<JsonMessage> createLeague(@RequestBody LeagueModel leagueModel) {
		try {
			leagueService.createLeague(leagueMapper.mapDto(leagueModel));
		} catch (ResourceAlreadyExists rae) {
			return new ResponseEntity<JsonMessage>(new JsonMessage(rae.getMessage()), HttpStatus.FOUND);
		}
		return new ResponseEntity<JsonMessage>(new JsonMessage("Liga creata"), HttpStatus.OK);
	}

	@RequestMapping(value = "/leagues", method = RequestMethod.GET)
	public ResponseEntity<List<LeagueModel>> getLeagues() {
		List<LeagueDTO> leaguesDto = leagueService.findAllLeagues();
		return new ResponseEntity<List<LeagueModel>>(leagueMapper.mapModelList(leaguesDto), HttpStatus.OK);
	}

}
