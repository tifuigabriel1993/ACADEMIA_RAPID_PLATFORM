package com.companyname.service.business.platform;

import org.springframework.web.context.request.WebRequest;

import com.companyname.persitence.entity.platform.User;
import com.companyname.service.dto.platform.UserDTO;

public interface UserService {

	void regsiterAndLogin(UserDTO userDto);

	User registerUser(UserDTO userDto);

	UserDTO getUserByUsername(String username);

	UserDTO getUserByEmail(String email);

	void socialRegisterAndLogin(UserDTO userDto, WebRequest request);

	void socialLinkAndLogin(UserDTO userDto, WebRequest request);

	boolean checkPassword(String username, String rawPassword);

}
