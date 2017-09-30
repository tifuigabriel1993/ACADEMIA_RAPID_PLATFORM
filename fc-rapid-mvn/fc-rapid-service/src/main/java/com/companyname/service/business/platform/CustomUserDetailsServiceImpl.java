package com.companyname.service.business.platform;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.platform.UserRepository;
import com.companyname.persitence.entity.platform.User;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.dto.platform.UserDetailsDTO;
import com.companyname.service.transformer.UserTransformer;
import com.companyname.service.util.SocialUtil;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTransformer userTransformer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

		UserDTO userDto = userTransformer.toDto(user);
		userDto.setProfilePhotoUrl(SocialUtil.buildFacebookPhotoUrl(user.getFacebookId()));

		return new UserDetailsDTO(userDto, grantedAuthorities);
	}

	public UserDetails loadUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);

		if (user == null) {
			throw new RuntimeException();
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

		UserDTO userDto = userTransformer.toDto(user);
		userDto.setProfilePhotoUrl(SocialUtil.buildFacebookPhotoUrl(user.getFacebookId()));

		return new UserDetailsDTO(userDto, grantedAuthorities);
	}

}
