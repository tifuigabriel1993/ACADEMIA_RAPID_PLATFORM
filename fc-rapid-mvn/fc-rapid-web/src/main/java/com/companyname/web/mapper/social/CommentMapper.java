package com.companyname.web.mapper.social;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.companyname.integration.util.DateUtil;
import com.companyname.service.dto.social.CommentDTO;
import com.companyname.service.util.SocialUtil;
import com.companyname.web.model.social.CommentModel;

@Component
public class CommentMapper {

	public CommentModel mapModel(CommentDTO commentDto) {
		CommentModel commentModel = new CommentModel();
		commentModel.setUsername(commentDto.getUsername());
		commentModel.setText(commentDto.getText());
		commentModel.setUserPhotoUrl(SocialUtil.buildFacebookPhotoUrl(commentDto.getUserDto().getFacebookId()));
		commentModel.setDate(DateUtil.formatActivityDate(commentDto.getCommentDate()));
		return commentModel;
	}

	public CommentDTO mapDto(CommentModel commentModel) {
		CommentDTO commentDto = new CommentDTO();
		commentDto.setPostId(commentModel.getPostId());
		commentDto.setText(commentModel.getText());
		commentDto.setUsername(commentModel.getUsername());
		return commentDto;
	}

	public List<CommentModel> mapModelList(List<CommentDTO> commentDtoList) {
		List<CommentModel> commentList = new ArrayList<>();
		if (commentDtoList != null) {
			commentDtoList.forEach((k) -> commentList.add(mapModel(k)));
		}
		return commentList;
	}

}
