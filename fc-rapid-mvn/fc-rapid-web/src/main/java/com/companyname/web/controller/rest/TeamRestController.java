package com.companyname.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.sport.TeamService;
import com.companyname.service.exception.ResourceAlreadyExists;
import com.companyname.web.mapper.sport.TeamMapper;
import com.companyname.web.model.platform.JsonMessage;
import com.companyname.web.model.sport.TeamModel;

@Controller
@RequestMapping("/api")
public class TeamRestController {

	@Autowired
	private TeamService teamService;

	@Autowired
	private TeamMapper teamMapper;

	@RequestMapping(value = "/team", method = RequestMethod.POST)
	public ResponseEntity<JsonMessage> createTeam(@RequestBody TeamModel teamModel) {
		try {
			teamService.addTeam(teamMapper.mapDto(teamModel));
		} catch (ResourceAlreadyExists rae) {
			return new ResponseEntity<JsonMessage>(new JsonMessage(rae.getMessage()), HttpStatus.FOUND);
		}
		return new ResponseEntity<JsonMessage>(new JsonMessage("Echipa creata"), HttpStatus.OK);
	}

}
