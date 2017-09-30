var ACCEPTED = 202;
var NOT_ACCEPTED = 406;

var usernameIsValid = 0;
var emailIsValid = 0;
var confirmEmailIsValid = 0;
var firstNameIsValid = 0;
var secondNameIsValid = 0;
var passwordIsValid = 0;
var confirmPasswordIsValid = 0;
var termsAndConditionsIsChecked = 0;

var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');

function enableDisableRegisterButton() {
	var registerButton_id = "#registerButton"
	if (Boolean(usernameIsValid) && Boolean(emailIsValid)
			&& Boolean(confirmEmailIsValid) && Boolean(firstNameIsValid)
			&& Boolean(secondNameIsValid) && Boolean(passwordIsValid)
			&& Boolean(confirmPasswordIsValid)
			&& Boolean(termsAndConditionsIsChecked)) {
		$(registerButton_id).prop('disabled', false);
		return;
	}
}

function init() {
	checkUsername();
	checkEmail();
	checkEqualsEmail();
	checkFirstName();
	checkSecondName();
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

function checkEmail() {
	var email_field_id = "#register_email";
	var email_message_field = "#register_email_checker";

	var confirm_mail_field_id = "#register_confirm_email";
	var confirm_mail_message_id = "#register_confirmemail_checker";

	resetFieldHtml(confirm_mail_field_id, confirm_mail_message_id);

	var email = $(email_field_id).val();

	if (email == "") {
		resetFieldHtml(email_field_id, email_message_field)
		return;
	}

	var message = validateEmail(email);

	if (message != "") {
		updateFieldHtml(email_field_id, email_message_field, message,
				NOT_ACCEPTED);
		return;
	}

	var resourceUri = "/user/email";
	var email_json = email;
	var status = getRequestStatusCode(resourceUri, email_json);
	if (status == ACCEPTED) {
		message += "Email-ul nu este folosit.";
		emailIsValid = 1;
	} else {
		message = "Email-ul este folosit.";
		emailIsValid = 0;
	}
	updateFieldHtml(email_field_id, email_message_field, message, status);
	$('#registerButton').prop('disabled', true);
}

function checkEqualsEmail() {
	var confirm_mail_field_id = "#register_confirm_email";
	var confirm_mail_message_id = "#register_confirmemail_checker";

	var email_field_id = "#register_email";
	var email_message_field = "#register_email_checker";

	var email = $(email_field_id).val();
	var confirmationEmail = $(confirm_mail_field_id).val();
	var message = "";

	if (email != confirmationEmail) {
		message = "Email-urile nu coincid.";
		confirmEmailIsValid = 0;
		updateFieldHtml(confirm_mail_field_id, confirm_mail_message_id,
				message, NOT_ACCEPTED);

	} else if (email == confirmationEmail && confirmationEmail != "") {
		confirmEmailIsValid = 1;
		updateFieldHtml(confirm_mail_field_id, confirm_mail_message_id,
				message, ACCEPTED);
	}
	enableDisableRegisterButton()
}

function checkFirstName() {
	var fieldId = "#register_firstname";
	var messageField = "#register_firstname_checker";

	var first_name = $(fieldId).val();

	if (first_name == "") {
		resetFieldHtml(fieldId, messageField);
		return;
	}
	var message = validateName(first_name, "Numele")
	if (message != "") {
		updateFieldHtml(fieldId, messageField, message, NOT_ACCEPTED)
		firstNameIsValid = 0;
	} else {
		updateFieldHtml(fieldId, messageField, "", ACCEPTED)
		firstNameIsValid = 1;
	}
	enableDisableRegisterButton()
}

function checkSecondName() {
	var fieldId = "#register_secondname";
	var messageField = "#register_secondname_checker";

	var first_name = $(fieldId).val();

	if (first_name == "") {
		resetFieldHtml(fieldId, messageField);
		return;
	}
	var message = validateName(first_name, "Prenumele")
	if (message != "") {
		updateFieldHtml(fieldId, messageField, message, NOT_ACCEPTED)
		secondNameIsValid = 0;
	} else {
		updateFieldHtml(fieldId, messageField, "", ACCEPTED)
		secondNameIsValid = 1;
	}
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

	} else if (password == confirmationPassword && password != "") {
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

function validateName(name, type) {
	var message = "";
	if (name.length < 2) {
		message = type + " trebuie sa contina minim 2 litere.";
	}
	var nameRegex = /[a-zA-z]$/;
	if (nameRegex.test(name) == false) {
		message = type + " trebuie sa contina doar litere.";
	}

	return message;
}

function validatePassword(password) {
	var message = ""
	if (password.length < 6 || password.length > 20) {
		message = "Parola trebuie sa contina intre 6 si 20 de caractere";
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
	}
	return message;
}

function validateEmail(email) {
	var message = "";
	if (!validateEmailFormat(email)) {
		message = "Format-ul email-ului nu este valid."
	}
	return message;
}

function validateEmailFormat(email) {
	var emailRegex = /[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$/;
	return emailRegex.test(email);
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