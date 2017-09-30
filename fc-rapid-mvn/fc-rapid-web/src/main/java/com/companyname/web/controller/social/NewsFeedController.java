package com.companyname.web.controller.social;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.web.util.Views;

@Controller
@RequestMapping("/platforma/noutati")
public class NewsFeedController {

	@RequestMapping(method = RequestMethod.GET)
	public String newsFeedView() {

		return Views.NEWSFEED_VIEW;
	}

}