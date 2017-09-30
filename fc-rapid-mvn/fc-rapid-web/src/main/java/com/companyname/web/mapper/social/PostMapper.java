package com.companyname.web.mapper.social;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.integration.util.DateUtil;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.web.model.social.PostModel;

@Component
public class PostMapper {

	@Autowired
	private CommentMapper commentMapper;

	public PostDTO mapDto(PostModel postModel) {
		PostDTO postDto = new PostDTO();
		postDto.setTitle(postModel.getTitle());
		postDto.setContent(postModel.getContent());
		return postDto;
	}

	public PostModel mapModel(PostDTO postDto) {
		PostModel postModel = new PostModel();
		postModel.setPostId(postDto.getPostId());
		postModel.setTitle(postDto.getTitle());
		postModel.setContent(postDto.getContent());
		postModel.setCreationDate(DateUtil.formatDate(postDto.getCreationDate()));
		postModel.setUsername(postDto.getUsername());
		postModel.setComments(commentMapper.mapModelList(postDto.getComments()));
		return postModel;
	}

	public List<PostModel> mapModelList(List<PostDTO> postDtoList) {
		List<PostModel> postModelList = new ArrayList<PostModel>();
		postDtoList.forEach((k) -> postModelList.add(mapModel(k)));
		return postModelList;
	}

}