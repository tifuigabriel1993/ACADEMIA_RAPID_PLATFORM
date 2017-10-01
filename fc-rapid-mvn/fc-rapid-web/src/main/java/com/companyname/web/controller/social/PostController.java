package com.companyname.web.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.social.PostServiceImpl;
import com.companyname.web.mapper.social.PostMapper;
import com.companyname.web.model.social.PostModel;
import com.companyname.web.util.Views;

@Controller
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostMapper postMapper;
	
	@RequestMapping(value = "/platforma/postare/{postId}", method = RequestMethod.GET)
	public String postView(@PathVariable ("postId") String postId, Model model) {

		PostModel post = postMapper.mapModel(postServiceImpl.getPostById(Long.parseLong(postId)));
		model.addAttribute("post", post);
		
		return Views.POST_VIEW;
	}
}
