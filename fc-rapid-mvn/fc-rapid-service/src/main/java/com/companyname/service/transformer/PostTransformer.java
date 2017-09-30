package com.companyname.service.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.social.Post;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.service.util.enums.PostTypeEnum;

@Component
public class PostTransformer {

	@Autowired
	private CommentTransformer commentTransformer;

	public Post toEntity(PostDTO postDto) {
		Post post = new Post();
		post.setPostDate(postDto.getCreationDate());
		post.setText(postDto.getContent());
		post.setTitle(postDto.getTitle());
		return post;
	}

	public PostDTO toDto(Post post, boolean transformComment) {
		PostDTO postDto = new PostDTO();
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getText());
		postDto.setPostId(post.getPostId());
		postDto.setCreationDate(post.getPostDate());
		postDto.setUsername(post.getAuthor().getUsername());
		if (transformComment) {
			postDto.setComments(commentTransformer.toDtoList(post.getComments(), false));
		}
		postDto.setType(PostTypeEnum.valueOf(post.getType()));

		return postDto;
	}

	public List<Post> toEntityList(List<PostDTO> postDtoList) {
		List<Post> postModelList = new ArrayList<Post>();
		postDtoList.forEach((k) -> postModelList.add(toEntity(k)));
		return postModelList;
	}

	public List<PostDTO> toDtoList(List<Post> postModelList, boolean transformComment) {
		List<PostDTO> postDtoList = new ArrayList<PostDTO>();
		postModelList.forEach((k) -> postDtoList.add(toDto(k, transformComment)));
		return postDtoList;
	}

}