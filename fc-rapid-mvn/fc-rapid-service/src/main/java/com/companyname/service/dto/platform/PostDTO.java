package com.companyname.service.dto.platform;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.companyname.service.dto.social.CommentDTO;
import com.companyname.service.util.enums.PostTypeEnum;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long postId;

	private String title;

	private String content;

	private Date creationDate;

	private String username;

	private List<CommentDTO> comments;
	
	private Set<String> categories;
	
	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private PostTypeEnum type;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public PostTypeEnum getType() {
		return type;
	}

	public void setType(PostTypeEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", title=" + title + ", content=" + content + ", creationDate="
				+ creationDate + ", username=" + username + ", comments=" + comments + ", type=" + type + "]";
	}

}
