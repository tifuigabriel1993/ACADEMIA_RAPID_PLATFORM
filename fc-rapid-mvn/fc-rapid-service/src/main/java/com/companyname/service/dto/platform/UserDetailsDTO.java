package com.companyname.service.dto.platform;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsDTO extends User {

	private static final long serialVersionUID = -1804224466143739952L;

	private UserDTO userDto;

	public UserDetailsDTO(UserDTO userDto, Collection<? extends GrantedAuthority> authorities) {
		super(userDto.getUsername(), userDto.getPassword(), authorities);
		this.userDto = userDto;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "UserDetailsDTO [userDto=" + userDto + "]";
	}

}
