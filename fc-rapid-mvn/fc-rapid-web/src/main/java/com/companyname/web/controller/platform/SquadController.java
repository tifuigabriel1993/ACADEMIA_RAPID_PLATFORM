package com.companyname.web.controller.platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.web.util.Views;

@Controller
@RequestMapping("/platforma/lot")
public class SquadController {

	@RequestMapping(method = RequestMethod.GET)
	public String squadView() {

		return Views.SQUAD_VIEW;
	}

}