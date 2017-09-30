package com.companyname.web.controller.platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.web.util.Views;

@Controller
@RequestMapping("/platforma/bilete")
public class TicketController {

	@RequestMapping(method=RequestMethod.GET)
	public String ticketView() {
		
		return Views.TICKETS_VIEW;
	}

}
