package com.companyname.service.business.social;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.platform.UserRepository;
import com.companyname.integration.repository.social.PostRepository;
import com.companyname.persitence.entity.platform.Role;
import com.companyname.persitence.entity.platform.User;
import com.companyname.persitence.entity.social.Post;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.service.transformer.PostTransformer;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostTransformer postTransformer;

	private static final int PAGE_SIZE = 5;

	private static final int USER_POSTS_FIRST_PAGE = 0;

	@Override
	public List<PostDTO> getPostsPage(int current_page, String type) {
		PageRequest pageRequest = new PageRequest(current_page, PAGE_SIZE,
				Direction.DESC, "postDate");
		Page<Post> findPostsPage = postRepository.findPostsByType(type,
				pageRequest);
		return postTransformer.toDtoList(findPostsPage.getContent(), true);
	}
	
	@Override
	public List<PostDTO> getPostsPage(int current_page, String type, Set<String> categories) {
		PageRequest pageRequest = new PageRequest(current_page, PAGE_SIZE,
				Direction.DESC, "postDate");
		Page<Post> findPostsPage = postRepository.findPostsByTypeAndCategory(type,
				categories, pageRequest);
		return postTransformer.toDtoList(findPostsPage.getContent(), true);
	}
	
	@Override
	public List<PostDTO> getUserLastPosts(String username, int page_size) {
		PageRequest pageRequest = new PageRequest(USER_POSTS_FIRST_PAGE, page_size, Direction.DESC, "postDate");
		Page<Post> userPosts = postRepository.findPostsByUser(username, pageRequest);
		return postTransformer.toDtoList(userPosts.getContent(), true);
	}

	@Override
	public void createPost(PostDTO postDto) {
		User user = userRepository.findUserByUsername(postDto.getUsername());
		Post post = postTransformer.toEntity(postDto);
		post.setAuthor(user);
		post.setType(getPostTypeByUserRole(user.getRole()));
		postRepository.save(post);
	}
	
	@Override
	public PostDTO getPostById(long id) {
		return postTransformer.toDto(postRepository.getOne(id), true);
	}

	private String getPostTypeByUserRole(Role role) {
		switch (role.getName()) {
		case "USER":
			return "NORMAL";
		default:
			return "OFFICIAL";
		}
	}

}
