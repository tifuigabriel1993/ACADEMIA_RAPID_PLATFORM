package com.companyname.service.business.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import com.companyname.service.dto.platform.UserDetailsDTO;
import com.companyname.service.dto.social.FacebookuserDetailsDTO;

public class SocialUsersDetailServiceImpl implements SocialUserDetailsService {

	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

	@Override
	public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetailsDTO userDetails = (UserDetailsDTO) customUserDetailsServiceImpl.loadUserByEmail(username);
		return new FacebookuserDetailsDTO(userDetails, userDetails.getUserDto());
	}

}