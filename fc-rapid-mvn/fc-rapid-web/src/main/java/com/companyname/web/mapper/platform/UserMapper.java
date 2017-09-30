package com.companyname.web.mapper.platform;

import org.springframework.stereotype.Component;

import com.companyname.service.dto.platform.UserDTO;
import com.companyname.web.model.platform.UserModel;

@Component
public class UserMapper {

	public UserDTO mapDto(UserModel userModel) {
		UserDTO userDto = new UserDTO();
		userDto.setFacebookId(userModel.getId());
		userDto.setEmail(userModel.getEmail());
		userDto.setUsername(userModel.getUsername());
		userDto.setFirstName(userModel.getFirst_name());
		userDto.setSecondName(userModel.getLast_name());
		userDto.setSocialUser(true);
		userDto.setPassword(userModel.getPassword());
		return userDto;
	}

}
