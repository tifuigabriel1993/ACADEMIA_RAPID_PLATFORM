var ACCEPTED = 202;
var NOT_ACCEPTED = 406;

var usernameIsValid = 0;
var passwordIsValid = 0;
var confirmPasswordIsValid = 0;
var termsAndConditionsIsChecked = 0;

var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');

function enableDisableRegisterButton() {
	var registerButton_id = "#registerButton"
	if (Boolean(usernameIsValid) && Boolean(passwordIsValid)
			&& Boolean(confirmPasswordIsValid)
			&& Boolean(termsAndConditionsIsChecked)) {
		$(registerButton_id).prop('disabled', false);
		$("#signupImage").removeClass("gradeoutimg");
		return;
	}
	$("#signupImage").addClass("gradeoutimg");
}

function init() {
	checkUsername();

	var first_name_id = "#register_firstname";
	var first_name_message = "#register_firstname_checker";
	updateFieldHtml(first_name_id, first_name_message, "", ACCEPTED);

	var second_name_id = "#register_secondname";
	var second_name_message = "#register_secondname_checker";
	updateFieldHtml(second_name_id, second_name_message, "", ACCEPTED);

	var email_field_id = "#register_email";
	var email_message_field = "#register_email_checker";
	updateFieldHtml(email_field_id, email_message_field, "", ACCEPTED);

	$('#termsAndConditions').prop('checked', false);
	termsAndConditionsIsChecked = 0;
}

function checkUsername() {
	var fieldId = "#register_username";
	var messageField = "#register_username_checker";

	var username = $(fieldId).val();

	if (username == "") {
		resetFieldHtml(fieldId, messageField);
		return;
	}

	var message = validateUsername(username);
	if (message != "") {
		updateFieldHtml(fieldId, messageField, message, NOT_ACCEPTED);
		return;
	}

	var resourceUri = "/user/username";
	var username_json = username
	var status = getRequestStatusCode(resourceUri, username_json);

	message = "";
	if (status == ACCEPTED) {
		usernameIsValid = 1;
	} else {
		message += "Username-ul nu este liber.";
		usernameIsValid = 0;
	}

	updateFieldHtml(fieldId, messageField, message, status);
	enableDisableRegisterButton()
}

function checkPassword() {
	var password_field_id = "#register_password";
	var password_message_field = "#register_password_checker";

	var confirm_password_field_id = "#register_confirmpassword";
	var confirm_password_message_id = "#register_confirmpassword_checker";

	resetFieldHtml(confirm_password_field_id, confirm_password_message_id);

	var password = $(password_field_id).val();
	if (password == "") {
		resetFieldHtml(password_field_id, password_message_field)
		return;
	}

	var message = validatePassword(password);
	if (message != "") {
		updateFieldHtml(password_field_id, password_message_field, message,
				NOT_ACCEPTED);
		passwordIsValid = 0;
	} else {
		passwordIsValid = 1;
		updateFieldHtml(password_field_id, password_message_field, "", ACCEPTED);
		$("#signupImage").addClass("gradeoutimg");
	}
	$('#registerButton').prop('disabled', true);
}

function checkEqualPasswords() {
	var password_field_id = "#register_password";
	var password_message_field = "#register_password_checker";

	var confirm_password_field_id = "#register_confirmpassword";
	var confirm_password_message_id = "#register_confirmpassword_checker";

	var password = $(password_field_id).val();
	var confirmationPassword = $(confirm_password_field_id).val();

	if (password != confirmationPassword) {
		var message = "Parolele nu coincid nu coincid.";
		updateFieldHtml(confirm_password_field_id, confirm_password_message_id,
				message, NOT_ACCEPTED);
		confirmPasswordIsValid = 0;
		$("#signupImage").addClass("gradeoutimg");

	} else if (password == confirmationPassword && password != ""
			&& !hasWhiteSpace(password)) {
		confirmPasswordIsValid = 1;
		updateFieldHtml(confirm_password_field_id, confirm_password_message_id,
				"", ACCEPTED);
		updateFieldHtml(password_field_id, password_message_field, "", ACCEPTED);

	}
	enableDisableRegisterButton();
}

function termsAndConditionsChecked() {
	if (termsAndConditionsIsChecked == 0) {
		termsAndConditionsIsChecked = 1;
		enableDisableRegisterButton();
	} else {
		termsAndConditionsIsChecked = 0;
		$('#registerButton').prop('disabled', true);
		$("#signupImage").addClass("gradeoutimg");
		return;
	}
}

function updateFieldHtml(html_field_id, html_message_id, message, status) {
	if (status == ACCEPTED) {
		$(html_message_id).css("display", "none");
		$(html_field_id).css({
			'border-left' : '3px solid #007213'
		});

	} else {
		$(html_message_id).html(message);
		$(html_message_id).css("color", "#a94442");
		$(html_message_id).css("background-color", "#f2dede");
		$(html_message_id).css("display", "block");
		$(html_field_id).css({
			'border-left' : '3px solid #fc5c44'
		});
		$('#registerButton').prop('disabled', true);
	}
}

function resetFieldHtml(html_field_id, html_message_id) {
	$(html_field_id).val("");
	$(html_message_id).css("display", "none");
	$(html_field_id).css({
		'border-left' : '3px solid #640020'
	});
	$('#registerButton').prop('disabled', true);
}

function validatePassword(password) {
	var message = ""
	if (password.length < 6 || password.length > 20) {
		message = "Parola trebuie sa contina intre 6 si 20 de caractere";
	} else if (hasWhiteSpace(password)) {
		message = "Parola nu trebuie sa contina spatii";
	}
	return message;
}

function validateUsername(username) {
	var message = "";
	if (username.length < 6) {
		message = "Username-ul trebuie sa contina minim 6 caractere";
	} else if (!isLetter(username[0])) {
		message = "Username-ul trebuie sa inceapa cu o litera";
	} else if (!validateUsernameFormat(username)) {
		message = "Username-ul trebuie sa contina doar litere si cifre";
	} else if (hasWhiteSpace(username)) {
		message = "Username-ul nu trebuie sa contina spatii";
	}
	return message;
}
function hasWhiteSpace(s) {
	return /\s/g.test(s);
}

function validateUsernameFormat(username) {
	var usernameRegex = /[a-zA-z]([a-zA-z0-9]){5,20}$/;
	return usernameRegex.test(username);
}

function isLetter(c) {
	return c.toLowerCase() != c.toUpperCase();
}

function getRequestStatusCode(URI, json) {
	var status;
	var jsonObject = json
	$.ajax({
		type : "POST",
		contentType : "application/json",
		async : false,
		url : URI,
		data : jsonObject,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = xhr.status;
		},
		error : function(data, textStatus, xhr) {
			status = xhr.status;
		}
	});
	return status;
}

function resetAndClear(fieldId, messageId, validationId) {
	resetFieldHtml(fieldId, messageId);
	$(validationId).css('display', 'none');
}

var correct_pass = 0;
var accepted_conditions = 0;

function enableButton() {
	if(correct_pass == 1 && accepted_conditions == 1) {
		$('#linkButton').prop('disabled', false);
		$("#signupImage").removeClass("gradeoutimg");
	}
	else {
		$('#linkButton').prop('disabled', true);
		$("#signupImage").addClass("gradeoutimg");
	}
}


function termsAndConditionsCheckedLink() {
	if (document.getElementById('termsAndConditionsLink').checked) {
		accepted_conditions = 1;
	} else {
		accepted_conditions = 0;
	}
	enableButton();
}

function checkPasswordBeforeLinking() {
	var password = $("#link_password").val();
	var username = $("#linked_username").val();

	var json_array = {
		"username" : username,
		"password" : password
	};

	var status = getPasswordStatus(json_array);

	var email_acc = $("#linked_email").val();
	var message;
	if(status == ACCEPTED) {
		message = "";
		updateFieldHtml("#link_password", "#link_password_msg", message, ACCEPTED);
		correct_pass = 1;
	}
	else {
		correct_pass = 0;
		message = "Introduceti parola contului: " + email_acc;
		updateFieldHtml("#link_password", "#link_password_msg", message, NOT_ACCEPTED);
	}
	enableButton();
}

function getPasswordStatus(json_array) {
	var status;
	var jsonObject = JSON.stringify(json_array);
	$.ajax({
		type : "POST",
		contentType : "application/json",
		async : false,
		url : "/user/password",
		data : jsonObject,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = xhr.status;
		},
		error : function(data, textStatus, xhr) {
			status = xhr.status;
		}
	});
	return status;
}

function updateFieldHtml(html_field_id, html_message_id, message, status) {
	if (status == ACCEPTED) {
		$(html_message_id).css("display", "none");
		$(html_field_id).css({
			'border-left' : '3px solid #007213'
		});

	} else {
		$(html_message_id).html(message);
		$(html_message_id).css("color", "#a94442");
		$(html_message_id).css("background-color", "#f2dede");
		$(html_message_id).css("display", "block");
		$(html_field_id).css({
			'border-left' : '3px solid #fc5c44'
		});
		$('#registerButton').prop('disabled', true);
	}
}