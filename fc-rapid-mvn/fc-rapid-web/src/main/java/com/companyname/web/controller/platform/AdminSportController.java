package com.companyname.web.controller.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.sport.LeagueService;
import com.companyname.service.business.sport.TeamService;
import com.companyname.service.dto.platform.TeamDTO;
import com.companyname.service.dto.sport.LeagueDTO;
import com.companyname.web.mapper.sport.LeagueMapper;
import com.companyname.web.util.Views;

@Controller
@RequestMapping("/administrare")
public class AdminSportController {

	@Autowired
	private LeagueService leagueService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private LeagueMapper leagueMapper;

	@RequestMapping(value = "/ligi", method = RequestMethod.GET)
	public String getLeagueAdministrationView(Model model) {
		return Views.ADMIN_LEAGUES_VIEW;
	}

	@RequestMapping(value = "/echipe", method = RequestMethod.GET)
	public String getTeamAdministrationView(Model model) {
		List<LeagueDTO> allLeagues = leagueService.findAllLeagues();
		model.addAttribute("leagues", leagueMapper.mapModelList(allLeagues));
		List<TeamDTO> teams = teamService.findAllTeams();
		model.addAttribute("teams", teams);
		return Views.ADMIN_TEAMS_VIEW;
	}

	@RequestMapping(value = "/etape", method = RequestMethod.GET)
	public String getRoundsAdministrationView(Model model) {
		List<LeagueDTO> allLeagues = leagueService.findAllLeagues();
		model.addAttribute("leagues", leagueMapper.mapModelList(allLeagues));
		return Views.ADMIN_ROUNDS_VIEW;
	}

	@RequestMapping(value = "/meciuri", method = RequestMethod.GET)
	public String getMatchAdministrationView(Model model) {

		return Views.ADMIN_MATCHES_VIEW;
	}

}