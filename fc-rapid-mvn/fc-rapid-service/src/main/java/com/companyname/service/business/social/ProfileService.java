package com.companyname.service.business.social;

import com.companyname.service.dto.social.ProfileDTO;

public interface ProfileService {

	void updateUserProfile(ProfileDTO profileDto);

	ProfileDTO findProfile(String username);

}
