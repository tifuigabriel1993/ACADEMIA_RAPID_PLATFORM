package com.companyname.web.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.companyname.service.business.social.CommentService;
import com.companyname.web.mapper.social.CommentMapper;
import com.companyname.web.model.social.CommentModel;
import com.companyname.web.util.SecurityUtil;
import com.companyname.web.util.Urls;

@Controller
public class CommentingController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentMapper commentMapper;

	@MessageMapping("/post/{post_id}/comments")
	public String commenting(@DestinationVariable String post_id, CommentModel commentModel) throws Exception {
		String username = SecurityUtil.getAuthenticatedUsername();
		if(username == null) {
			return "redirect:" + Urls.COMMENT_NOT_LOGGED_IN;
		}
		commentModel.setUsername(username);
		commentModel.setPostId(Long.valueOf(post_id));
		commentService.saveCommentAndSend(commentMapper.mapDto(commentModel));
		return null;
	}

}