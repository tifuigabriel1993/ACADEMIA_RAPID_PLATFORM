package com.companyname.service.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.platform.User;
import com.companyname.persitence.entity.social.Profile;
import com.companyname.service.dto.social.ProfileDTO;

@Component
public class ProfileTransformer {

	@Autowired
	private UserTransformer userTransformer;

	@Autowired
	private AddressTransformer addressTransformer;

	public ProfileDTO toDto(User user) {
		Profile userProfile = user.getUserProfile();

		ProfileDTO profileDto = new ProfileDTO();
		if (userProfile != null) {
			profileDto.setProfileId(userProfile.getProfileId());
			profileDto.setNickName(userProfile.getNickName());
			profileDto.setBirthDay(userProfile.getBirthday());
			profileDto.setFootballInfo(userProfile.getFootballInfo());
			profileDto.setSex(userProfile.getSex());
		}
		profileDto.setUserDto(userTransformer.toDto(user));
		if (userProfile != null) {
			profileDto.setAddressDto(addressTransformer.toDto(userProfile.getAddress()));
		}
		return profileDto;
	}

	public Profile toEntity(ProfileDTO profileDto) {
		Profile profile = new Profile();
		profile.setNickName(profileDto.getNickName());
		profile.setBirthday(profileDto.getBirthDay());
		profile.setFootballInfo(profileDto.getFootballInfo());
		profile.setSex(profileDto.getSex());
		return profile;
	}

}
