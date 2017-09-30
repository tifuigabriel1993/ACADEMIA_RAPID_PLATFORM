package com.companyname.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.social.ProfileService;
import com.companyname.service.dto.social.ProfileDTO;
import com.companyname.web.mapper.social.ProfileMapper;
import com.companyname.web.model.social.ProfileModel;
import com.companyname.web.util.SecurityUtil;

@Controller
@RequestMapping("/api/profile")
public class ProfileRestController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProfileMapper profileMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> updateProfile(@RequestBody ProfileModel profileModel) {
		profileModel.setUsername(SecurityUtil.getAuthenticatedUsername());
		ProfileDTO profileDto = profileMapper.mapDto(profileModel);
		profileService.updateUserProfile(profileDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}