package com.companyname.web.controller.platform;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.web.util.SecurityUtil;
import com.companyname.web.util.Urls;
import com.companyname.web.util.Views;

@Controller
public class LoginController {

	private static final String NOT_LOGGED_IN = "anonymousUser";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof String && NOT_LOGGED_IN.equals(principal)) {
			return Views.LOGIN_VIEW;
		}
		return "redirect:" + Urls.AFTER_LOGIN_REDIRECT;
	}

	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	public ResponseEntity<String> loggedIn() {
		String authenticatedUsername = SecurityUtil.getAuthenticatedUsername();
		if (authenticatedUsername == null) {
			return new ResponseEntity<String>(HttpStatus.PRECONDITION_FAILED);
		}
		String userRole = SecurityUtil.getAuthenticatedUserRole();
		return new ResponseEntity<String>(userRole, HttpStatus.ACCEPTED);
	}

}