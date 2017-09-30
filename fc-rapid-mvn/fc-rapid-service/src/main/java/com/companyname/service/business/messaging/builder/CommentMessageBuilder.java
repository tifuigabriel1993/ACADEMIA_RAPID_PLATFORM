package com.companyname.service.business.messaging.builder;

import org.springframework.stereotype.Component;

import com.companyname.service.business.messaging.model.CommentMessage;
import com.companyname.service.dto.social.CommentDTO;

@Component
public class CommentMessageBuilder {

	public CommentMessage createComment(CommentDTO commentDto, String url) {
		CommentMessage commentMessage = new CommentMessage(url, commentDto.getUsername());
		commentMessage.setText(commentDto.getText());
		return commentMessage;
	}

}
