package com.companyname.service.business.messaging.builder;

import org.springframework.stereotype.Component;

@Component
public class MessagingUrlBuilder {

	private static final String FIRST_POST_URL_FRAGMENT = "/topic/post/";

	private static final String COMMENT_URL_FRAGMENT = "/comments";

	public String getCommentToPostUrl(Long postId) {
		return FIRST_POST_URL_FRAGMENT + postId + COMMENT_URL_FRAGMENT;
	}

}