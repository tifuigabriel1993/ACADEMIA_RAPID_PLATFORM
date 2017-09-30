package com.companyname.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.service.business.platform.UserService;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.web.model.platform.UsernamePasswordModel;
import com.companyname.web.model.platform.ValidationMessage;

@RestController
public class RegisterRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/username", method = RequestMethod.POST)
	public ResponseEntity<ValidationMessage> checkUsername(@RequestBody String username) {
		UserDTO user = userService.getUserByUsername(username.toLowerCase());
		ValidationMessage validationMessage = new ValidationMessage();
		if (user == null) {
			validationMessage.setMessage("Username-ul nu este folosit.");
			return new ResponseEntity<>(validationMessage, HttpStatus.ACCEPTED);
		}
		validationMessage.setMessage("Username-ul este folosit");
		return new ResponseEntity<>(validationMessage, HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value = "/user/email", method = RequestMethod.POST)
	public ResponseEntity<ValidationMessage> checkEmail(@RequestBody String email) {
		UserDTO user = userService.getUserByEmail(email.toLowerCase());
		ValidationMessage validationMessage = new ValidationMessage();
		if (user == null) {
			validationMessage.setMessage("Email-ul nu este folosit.");
			return new ResponseEntity<>(validationMessage, HttpStatus.ACCEPTED);
		}
		validationMessage.setMessage("Email-ul este folosit");
		return new ResponseEntity<>(validationMessage, HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value = "/user/password", method = RequestMethod.POST)
	public ResponseEntity<ValidationMessage> checkPassword(@RequestBody UsernamePasswordModel usernamePassword) {
		boolean isMatching = userService.checkPassword(usernamePassword.getUsername(), usernamePassword.getPassword());
		ValidationMessage validationMessage = new ValidationMessage();
		if (isMatching) {
			validationMessage.setMessage("Parola este corecta");
			return new ResponseEntity<>(validationMessage, HttpStatus.ACCEPTED);
		}
		validationMessage.setMessage("Parola nu este corecta");
		return new ResponseEntity<>(validationMessage, HttpStatus.NOT_ACCEPTABLE);
	}

}