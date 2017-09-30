/**
 * 
 */

var PROFILE_URI = "/api/profile";

function updateProfile() {
	var profile = {};
	profile["firstName"] = $("#profile_first_name").val();
	profile["secondName"] = $("#profile_second_name").val();
	profile["sex"] = $("#profile_sex").val();
	profile["footballInfo"] = $("#footballInfo").val();

	var address = {};
	address["country"] = $("#profile_country").val();
	address["city"] = $("#profile_city").val();
	profile["address"] = address;

	var status;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : PROFILE_URI,
		data : JSON.stringify(profile),
		dataType : 'json',
		async : false,
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
	location.reload();
}