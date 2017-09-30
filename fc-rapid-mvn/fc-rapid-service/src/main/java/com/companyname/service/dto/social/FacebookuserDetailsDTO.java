package com.companyname.service.dto.social;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.dto.platform.UserDetailsDTO;

public class FacebookuserDetailsDTO implements SocialUserDetails, Serializable {

	private static final long serialVersionUID = -207928141437178484L;

	private UserDetailsDTO userDetails;

	private UserDTO userDto;

	public FacebookuserDetailsDTO(UserDetailsDTO userDetails, UserDTO userDto) {
		this.userDetails = userDetails;
		this.userDto = userDto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDetails.getAuthorities();
	}

	@Override
	public String getPassword() {
		return userDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return userDetails.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userDetails.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return userDetails.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userDetails.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return userDetails.isEnabled();
	}

	@Override
	public String getUserId() {
		return userDetails.getUsername();
	}

	public UserDetailsDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsDTO userDetails) {
		this.userDetails = userDetails;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

}