function init(){
	if (window.location.pathname == "/logare"){
		$('#invalidUsernameOrPasswrd').css('display', 'block');
	}
}

var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');
var csrf_paramter_name=$('meta[name="_csrf_parameterName"]').attr('content');