package com.companyname.web.controller.rest;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.companyname.service.business.social.PostService;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.web.mapper.social.PostMapper;
import com.companyname.web.model.social.PostModel;
import com.companyname.web.model.social.PostsWrapper;
import com.companyname.web.util.SecurityUtil;

@Controller
@RequestMapping("/api/post")
public class PostRestController {

	@Autowired
	private PostService postService;

	@Autowired
	private PostMapper postMapper;

	private static final int PAGE_SIZE = 5;

	@RequestMapping(value = "/{type}/{categories}",method = RequestMethod.GET)
	public ResponseEntity<PostsWrapper> getPosts(@RequestParam("currentPage") int currentPage, @PathVariable("type") String type,
			@PathVariable("categories") Set<String> categories) {
		
		List<PostDTO> postsPage = null;
		
		if (categories.size() <= 1) {
			postsPage = postService.getPostsPage(currentPage, type);
		}else {
			postsPage = postService.getPostsPage(currentPage, type, categories);
		}
		
		List<PostModel> postsModelList = postMapper.mapModelList(postsPage);
		PostsWrapper postsWrapepr = new PostsWrapper(postsModelList, findNextPage(postsModelList, currentPage));
		return new ResponseEntity<PostsWrapper>(postsWrapepr, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody @Valid PostModel postModel, BindingResult result) {
		
		if (result.hasErrors()){
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		PostDTO postDto = postMapper.mapDto(postModel);
		postDto.setCreationDate(new Date());
		postDto.setUsername(SecurityUtil.getAuthenticatedUsername());
		postService.createPost(postDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	private int findNextPage(List<PostModel> postsModelList, int current_page) {
		if (postsModelList.size() < PAGE_SIZE) {
			return -1;
		}
		return current_page + 1;
	}

}