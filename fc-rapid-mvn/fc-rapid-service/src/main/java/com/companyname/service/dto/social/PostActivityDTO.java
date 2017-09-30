package com.companyname.service.dto.social;

public class PostActivityDTO extends SimpleActivityDTO {

	private static final long serialVersionUID = 5759481954045279465L;

	private String postTitle;

	private String postUrl;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	@Override
	public String toString() {
		return "PostActivityDTO [postTitle=" + postTitle + ", postUrl=" + postUrl + "]";
	}

}
