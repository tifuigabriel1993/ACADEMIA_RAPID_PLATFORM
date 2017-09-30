package com.companyname.service.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.social.Comment;
import com.companyname.service.dto.social.CommentDTO;

@Component
public class CommentTransformer {

	@Autowired
	private PostTransformer postTransformer;

	@Autowired
	private UserTransformer userTransformer;

	public Comment toEntity(CommentDTO commentDto) {
		Comment comment = new Comment();
		comment.setCommentId(commentDto.getCommentId());
		comment.setText(commentDto.getText());
		comment.setCommentDate(commentDto.getCommentDate());
		return comment;
	}

	public CommentDTO toDto(Comment comment, boolean transformPost) {
		CommentDTO commentDto = new CommentDTO();
		commentDto.setCommentId(comment.getCommentId());
		commentDto.setText(comment.getText());
		commentDto.setUsername(comment.getAuthor().getUsername());
		commentDto.setCommentDate(comment.getCommentDate());
		if (transformPost) {
			commentDto.setPostDto(postTransformer.toDto(comment.getPost(), false));
		}
		commentDto.setUserDto(userTransformer.toDto(comment.getAuthor()));
		return commentDto;
	}

	public List<Comment> toEntityList(List<CommentDTO> commentDtos) {
		List<Comment> comments = new ArrayList<Comment>();
		commentDtos.forEach((k) -> comments.add(toEntity(k)));
		return comments;
	}

	public List<CommentDTO> toDtoList(List<Comment> commentModelList, boolean transformPost) {
		List<CommentDTO> commentDtoList = new ArrayList<CommentDTO>();
		commentModelList.forEach((k) -> commentDtoList.add(toDto(k, transformPost)));
		return commentDtoList;
	}

}
