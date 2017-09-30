package com.companyname.web.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.companyname.service.business.platform.UserService;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.web.mapper.platform.UserMapper;
import com.companyname.web.model.platform.UserModel;
import com.companyname.web.util.FacebookBioFields;
import com.companyname.web.util.Urls;
import com.companyname.web.util.Views;

@Controller
public class FacebookSignUpController {

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String redirectRequestToRegistrationPage(WebRequest request, Model model) {
		Connection<Facebook> connection = (Connection<Facebook>) providerSignInUtils.getConnectionFromSession(request);
		Facebook facebook = connection.getApi();

		UserModel userModel = facebook.fetchObject("me", UserModel.class, FacebookBioFields.EXTRACTED_FIELDS);
		String facebookEmail = userModel.getEmail();
		if(facebookEmail == null) {
			model.addAttribute("noMail", true);
			return Views.SIGN_UP_VIEW;
		}
		model.addAttribute("noMail", false);

		UserDTO alreadyRegistered = userService.getUserByEmail(facebookEmail);
		boolean mustBeLinked = alreadyRegistered == null ? false : true;
		if (mustBeLinked) {
			addExistingDetails(userModel, alreadyRegistered);
		}

		model.addAttribute("userModel", userModel);
		model.addAttribute("mustBeLinked", mustBeLinked);

		return Views.SIGN_UP_VIEW;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registrationUser(@ModelAttribute("userModel") UserModel userModel, WebRequest request)
			throws Exception {
		UserDTO userDto = userMapper.mapDto(userModel);
		userService.socialRegisterAndLogin(userDto, request);
		return "redirect:" + Urls.AFTER_LOGIN_REDIRECT;
	}

	@RequestMapping(value = "/link-accounts", method = RequestMethod.POST)
	public String linkFacebookAccount(@ModelAttribute("userModel") UserModel userModel, WebRequest request) throws Exception {
		UserDTO userDto = userMapper.mapDto(userModel);
		userService.socialLinkAndLogin(userDto, request);
		return "redirect:" + Urls.AFTER_LOGIN_REDIRECT;
	}

	private void addExistingDetails(UserModel userModel, UserDTO userDto) {
		userModel.setUsername(userDto.getUsername());
		userModel.setEmail(userDto.getEmail());
	}

}