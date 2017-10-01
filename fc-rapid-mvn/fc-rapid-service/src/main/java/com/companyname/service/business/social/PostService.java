package com.companyname.service.business.social;

import java.util.List;
import java.util.Set;

import com.companyname.service.dto.platform.PostDTO;

public interface PostService {

	void createPost(PostDTO postDto);

	List<PostDTO> getPostsPage(int current_page, String type);

	List<PostDTO> getPostsPage(int current_page, String type,
			Set<String> categories);
	
	List<PostDTO> getUserLastPosts(String username, int page_size);

	PostDTO getPostById (long id);

}
