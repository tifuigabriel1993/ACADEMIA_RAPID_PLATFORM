package com.companyname.web.mapper.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.integration.util.DateUtil;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.dto.social.ProfileDTO;
import com.companyname.web.model.social.ProfileModel;

@Component
public class ProfileMapper {

	@Autowired
	private ActivityMapper activityMapper;

	@Autowired
	private AddressMapper addressMapper;

	public ProfileDTO mapDto(ProfileModel profileModel) {
		ProfileDTO profileDto = new ProfileDTO();

		profileDto.setNickName(profileModel.getNickName());
		if (profileModel.getBirthDay() != null) {
			profileDto.setBirthDay(DateUtil.parseDate(profileModel.getBirthDay()));
		}
		profileDto.setFootballInfo(profileModel.getFootballInfo());
		profileDto.setSex(profileModel.getSex());

		UserDTO userDto = new UserDTO();
		userDto.setUsername(profileModel.getUsername());
		userDto.setFirstName(profileModel.getFirstName());
		userDto.setSecondName(profileModel.getSecondName());
		profileDto.setUserDto(userDto);

		profileDto.setAddressDto(addressMapper.mapDto(profileModel.getAddress()));

		return profileDto;
	}

	public ProfileModel mapModel(ProfileDTO profileDto) {
		ProfileModel profileModel = new ProfileModel();
		profileModel.setUsername(profileDto.getUserDto().getUsername());
		profileModel.setEmail(profileDto.getUserDto().getEmail());
		profileModel.setFirstName(profileDto.getUserDto().getFirstName());
		profileModel.setSecondName(profileDto.getUserDto().getSecondName());
		profileModel.setNickName(profileDto.getNickName());
		profileModel.setSex(profileDto.getSex());
		profileModel.setPhotoUrl(profileDto.getUrlPhoto());
		profileModel.setPostsNumber(profileDto.getUserPostsNumber());
		profileModel.setCommentsNumber(profileDto.getUserCommentsNumber());
		if (profileDto.getBirthDay() != null) {
			profileModel.setBirthDay(profileDto.getBirthDay().toString());
		}
		profileModel.setFootballInfo(profileDto.getFootballInfo());
		profileModel.setAddress(addressMapper.mapModel(profileDto.getAddressDto()));
		if (profileDto.getActivities() != null) {
			profileModel.setActivities(activityMapper.mapModelList(profileDto.getActivities()));
		}
		return profileModel;
	}

}
