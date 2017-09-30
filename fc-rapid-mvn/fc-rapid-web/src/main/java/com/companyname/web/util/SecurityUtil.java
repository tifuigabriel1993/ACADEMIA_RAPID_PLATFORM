package com.companyname.web.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;

import com.companyname.service.dto.platform.UserDetailsDTO;
import com.companyname.service.dto.social.FacebookuserDetailsDTO;

public class SecurityUtil {

	public static CsrfToken getCsrfTokenFromServletRequest(HttpServletRequest httpServletRequest) {
		CsrfToken token = (CsrfToken) httpServletRequest.getAttribute(CsrfToken.class.getName());
		return token;
	}

	public static String getAuthenticatedUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetailsDTO) {
			UserDetailsDTO userDetails = (UserDetailsDTO) principal;
			return userDetails.getUsername();
		} else if (principal instanceof FacebookuserDetailsDTO) {
			FacebookuserDetailsDTO facebookUserDetails = (FacebookuserDetailsDTO) principal;
			return facebookUserDetails.getUsername();
		}
		return null;
	}
}
