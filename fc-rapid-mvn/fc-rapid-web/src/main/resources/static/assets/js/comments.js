var stompClients = [];

var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');

var post_comments_list = "post_comments";

var headers = {};
headers[csrf_header_name] = csrf_token;

function connectToPost(post_id) {
	var socket = new SockJS('/post/' + post_id + '/comments');
	stompClients[post_id] = Stomp.over(socket);
	stompClients[post_id].connect(headers, function(frame) {
		stompClients[post_id]
				.subscribe('/topic/post/' + post_id + '/comments',
						function(comment_json) {
							var comment = createComment(JSON
									.parse(comment_json.body));
							var commentlistid = "#" + post_comments_list
									+ post_id;
							$(commentlistid).append(comment);
						});
	});
}

function disconnectFromPost(post_id) {
	if (stompClients[post_id] !== null) {
		stompClients[post_id].disconnect();
	}
}

var textareaid = "text_area";

// sendName
function sendComment(post_id) {
	var stompClient = stompClients[post_id];
	var textarea_id = textareaid + post_id;
	if($("#" + textarea_id).val() !='') {
		stompClient.send('/app/post/' + post_id + '/comments', {}, JSON.stringify({
			'text' : $("#" + textarea_id).val()
		}));
		$("#" + textarea_id).val('');
	}
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
})