package com.companyname.service.business.platform;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;

import com.companyname.integration.repository.platform.RoleRepository;
import com.companyname.integration.repository.platform.UserRepository;
import com.companyname.persitence.entity.platform.Role;
import com.companyname.persitence.entity.platform.User;
import com.companyname.persitence.enums.RoleEnum;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.transformer.UserTransformer;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserTransformer userTransformer;

	@Override
	@Transactional
	public void socialLinkAndLogin(UserDTO userDto, WebRequest request) {
		providerSignInUtils.doPostSignUp(userDto.getEmail(), request);
		loginService.autologin(userDto.getUsername(), userDto.getPassword());
	}

	@Override
	@Transactional
	public void socialRegisterAndLogin(UserDTO userDto, WebRequest request) {
		providerSignInUtils.doPostSignUp(userDto.getEmail(), request);
		regsiterAndLogin(userDto);
	}

	@Override
	@Transactional
	public void regsiterAndLogin(UserDTO userDto) {
		registerUser(userDto);
		loginService.autologin(userDto.getUsername(), userDto.getPassword());
	}

	@Override
	@Transactional
	public User registerUser(UserDTO userDto) {
		User user = userTransformer.toEntity(userDto);
		user.setRole(getUserRole());
		user.setRegisterDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public boolean checkPassword(String username, String rawPassword) {
		String encodedPassword = userRepository.getPasswordByUsername(username);
		return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
	}

	public Role getUserRole() {
		return roleRepository.findByName(RoleEnum.USER.name());
	}

	@Override
	public UserDTO getUserByUsername(String username) {
		User user = userRepository.findUserByUsername(username);
		return user != null ? userTransformer.toDto(user) : null;
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		return user != null ? userTransformer.toDto(user) : null;
	}

}