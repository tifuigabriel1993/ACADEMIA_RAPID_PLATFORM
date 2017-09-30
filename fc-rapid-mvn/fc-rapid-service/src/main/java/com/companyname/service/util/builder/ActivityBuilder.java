package com.companyname.service.util.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.platform.User;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.service.dto.social.CommentDTO;
import com.companyname.service.dto.social.PostActivityDTO;
import com.companyname.service.dto.social.RegisterActivityDTO;
import com.companyname.service.dto.social.SimpleActivityDTO;

@Component
public class ActivityBuilder {

	public SimpleActivityDTO buildRegistrationActivity(User user) {
		RegisterActivityDTO registerActivity = new RegisterActivityDTO();
		registerActivity.setDescription(ActivityMessageConstant.REGISTER_ACTIVITY);
		registerActivity.setDate(user.getRegisterDate());
		registerActivity.setUsername(user.getUsername());
		return registerActivity;
	}

	public List<SimpleActivityDTO> buildPostingActivities(List<PostDTO> posts) {
		List<SimpleActivityDTO> activities = new ArrayList<>();
		posts.forEach((k) -> activities.add(buildPostingActivity(k)));
		return activities;
	}

	public SimpleActivityDTO buildCommentingActivity(CommentDTO commentDto) {
		PostActivityDTO postActivityDto = new PostActivityDTO();
		postActivityDto.setDate(commentDto.getCommentDate());
		postActivityDto.setDescription(ActivityMessageConstant.COMMENT_ACTIVITY);
		postActivityDto.setPostTitle(commentDto.getPostDto().getTitle());
		postActivityDto.setPostUrl(String.valueOf(commentDto.getPostDto().getPostId()));
		return postActivityDto;
	}

	public List<SimpleActivityDTO> buildCommentingActivities(List<CommentDTO> comments) {
		List<SimpleActivityDTO> activities = new ArrayList<>();
		comments.forEach((k) -> activities.add(buildCommentingActivity(k)));
		return activities;
	}

	public SimpleActivityDTO buildPostingActivity(PostDTO postDto) {
		PostActivityDTO postActivityDto = new PostActivityDTO();
		postActivityDto.setDate(postDto.getCreationDate());
		postActivityDto.setDescription(ActivityMessageConstant.POST_ACTIVITY);
		postActivityDto.setPostTitle(postDto.getTitle());
		postActivityDto.setPostUrl(String.valueOf(postDto.getPostId()));
		return postActivityDto;
	}

}
