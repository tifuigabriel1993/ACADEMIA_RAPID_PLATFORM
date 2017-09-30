package com.companyname.web.model.social;

import java.util.List;

public class PostsWrapper {

	private List<PostModel> posts;

	private Integer nextPage;

	public PostsWrapper(List<PostModel> posts, int nextPage) {
		super();
		this.posts = posts;
		this.nextPage = nextPage;
	}

	public List<PostModel> getPosts() {
		return posts;
	}

	public void setPosts(List<PostModel> posts) {
		this.posts = posts;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String toString() {
		return "PostsWrapper [posts=" + posts + ", nextPage=" + nextPage + "]";
	}

}
