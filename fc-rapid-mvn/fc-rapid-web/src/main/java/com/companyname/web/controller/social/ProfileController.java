package com.companyname.web.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.social.ProfileService;
import com.companyname.service.dto.social.ProfileDTO;
import com.companyname.service.exception.UserNotFoundException;
import com.companyname.web.mapper.social.ProfileMapper;
import com.companyname.web.util.SecurityUtil;
import com.companyname.web.util.Views;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProfileMapper profileMapper;

	@RequestMapping(value = "/profilul-meu", method = RequestMethod.GET)
	public String myProfileView(Model model) {
		ProfileDTO profile = null;
		try {
			profile = profileService.findProfile(SecurityUtil.getAuthenticatedUsername());
		} catch (UserNotFoundException unfe) {
			return "redirect:/inexistent?profil";
		}
		model.addAttribute("profile", profileMapper.mapModel(profile));
		return Views.MY_PROFILE_VIEW;
	}

	@RequestMapping(value = "/profil/{username:.+}", method = RequestMethod.GET)
	public String userProfileView(@PathVariable("username") String username, Model model) {
		ProfileDTO profile = null;
		try {
			profile = profileService.findProfile(username);
		} catch (UserNotFoundException unfe) {
			return "redirect:/inexistent?profil";
		}
		model.addAttribute("profile", profileMapper.mapModel(profile));
		return Views.USER_PROFILE_VIEW;
	}

}
