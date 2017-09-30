package com.companyname.web.controller.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.service.business.platform.UserService;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.web.model.platform.UserWrapper;
import com.companyname.web.util.Views;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/inregistrare", method = RequestMethod.GET)
	public String registerView(Model model) {
		model.addAttribute("userWrapper", new UserWrapper());
		return Views.REGISTER_VIEW;
	}

	@RequestMapping(value = "/inregistrare", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute("userWrapper") UserWrapper userWrapper, BindingResult result) {
		userService.regsiterAndLogin((UserDTO) userWrapper);
		return "redirect:/platforma/noutati";
	}

}