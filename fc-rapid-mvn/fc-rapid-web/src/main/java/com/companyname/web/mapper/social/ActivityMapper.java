package com.companyname.web.mapper.social;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.companyname.integration.util.DateUtil;
import com.companyname.service.dto.social.PostActivityDTO;
import com.companyname.service.dto.social.RegisterActivityDTO;
import com.companyname.service.dto.social.SimpleActivityDTO;
import com.companyname.web.model.social.ActivityModel;

@Component
public class ActivityMapper {

	public ActivityModel mapModel(SimpleActivityDTO activityDto) {
		ActivityModel activityModel = new ActivityModel();
		activityModel.setActivityDescription(activityDto.getDescription());
		activityModel.setActivityDate(DateUtil.formatActivityDate(activityDto.getDate()));
		if (activityDto instanceof PostActivityDTO) {
			mapNotGeneralFields(activityModel, (PostActivityDTO) activityDto);
		}
		if (activityDto instanceof RegisterActivityDTO) {
			mapNotGeneralFields(activityModel, (RegisterActivityDTO) activityDto);
		}
		return activityModel;
	}

	public Set<ActivityModel> mapModelList(Set<SimpleActivityDTO> activitiesDto) {
		Set<ActivityModel> activities = new LinkedHashSet<>();
		activitiesDto.forEach((k) -> activities.add(mapModel(k)));
		return activities;
	}

	private void mapNotGeneralFields(ActivityModel activityModel, PostActivityDTO postActivity) {
		activityModel.setActivityTitle(postActivity.getPostTitle());
		activityModel.setActivityUrl(postActivity.getPostUrl());
	}

	private void mapNotGeneralFields(ActivityModel activityModel, RegisterActivityDTO registerActivity) {
		activityModel.setActivityTitle(registerActivity.getUsername());
	}

}
