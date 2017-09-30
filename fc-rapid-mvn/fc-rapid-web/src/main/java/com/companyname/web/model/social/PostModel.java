package com.companyname.web.model.social;

import java.util.List;

public class PostModel {

	private Long postId;

	private String title;

	private String content;

	private String username;

	private String creationDate;

	private List<CommentModel> comments;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public List<CommentModel> getComments() {
		return comments;
	}

	public void setComments(List<CommentModel> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PostModel [postId=" + postId + ", title=" + title + ", content=" + content + ", username=" + username
				+ ", creationDate=" + creationDate + ", comments=" + comments + "]";
	}

}