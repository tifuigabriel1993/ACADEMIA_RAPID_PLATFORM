package com.companyname.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.sport.MatchService;
import com.companyname.service.exception.ResourceAlreadyExists;
import com.companyname.web.mapper.sport.MatchMapper;
import com.companyname.web.model.platform.JsonMessage;
import com.companyname.web.model.sport.MatchModel;

@Controller
@RequestMapping("/api")
public class MatchRestController {

	@Autowired
	private MatchService matchService;

	@Autowired
	private MatchMapper matchMapper;

	@RequestMapping(value = "/match", method = RequestMethod.POST)
	public ResponseEntity<JsonMessage> createTeam(@RequestBody MatchModel matchModel) {
		try {
			matchService.addMatch(matchMapper.mapDto(matchModel));
		} catch (ResourceAlreadyExists rae) {
			return new ResponseEntity<JsonMessage>(new JsonMessage(rae.getMessage()), HttpStatus.FOUND);
		}
		return new ResponseEntity<JsonMessage>(new JsonMessage("Match creat"), HttpStatus.OK);
	}

}
