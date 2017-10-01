package com.companyname.service.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.platform.User;
import com.companyname.service.dto.platform.UserDTO;

@Component
public class UserTransformer {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User toEntity(UserDTO userDto) {
		User userEntity = new User();
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setEmail(userDto.getEmail());
		userEntity.setFacebookId(userDto.getFacebookId());
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getSecondName());
		userEntity.setSocialUser(userDto.isSocialUser());
		userEntity.setFacebookId(userDto.getFacebookId());
		return userEntity;
	}

	public UserDTO toDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(user.getEmail());
		userDto.setUsername(user.getUsername());
		userDto.setFirstName(user.getFirstName());
		userDto.setSecondName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setSocialUser(user.isSocialUser());
		userDto.setFacebookId(user.getFacebookId());
		userDto.setRole(user.getRole().getName());
		return userDto;
	}

}
