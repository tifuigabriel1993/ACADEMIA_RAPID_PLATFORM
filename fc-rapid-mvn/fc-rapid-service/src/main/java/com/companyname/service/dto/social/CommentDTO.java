package com.companyname.service.dto.social;

import java.io.Serializable;
import java.util.Date;

import com.companyname.service.dto.platform.PostDTO;
import com.companyname.service.dto.platform.UserDTO;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long commentId;

	private long postId;

	private String username;

	private String text;

	private Date commentDate;

	private UserDTO userDto;

	private PostDTO postDto;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public PostDTO getPostDto() {
		return postDto;
	}

	public void setPostDto(PostDTO postDto) {
		this.postDto = postDto;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", postId=" + postId + ", username=" + username + ", text=" + text
				+ ", commentDate=" + commentDate + ", userDto=" + userDto + ", postDto=" + postDto + "]";
	}

}
