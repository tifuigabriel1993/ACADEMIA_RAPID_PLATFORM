var POST_URI = "/api/post";
var PAGE_URI_PATTERN = "?currentPage=";
var TYPE_URI_PATTERN = "?type=";

var csrf_token = $('meta[name="_csrf"]').attr('content');
var csrf_header_name = $('meta[name="_csrf_header"]').attr('content');

var CURRENT_PAGE = 0;

var post_comments_container = "content-text";
var post_comments_list = "post_comments";
var comment_list_wrapper = "div_comments_wrapper";
var see_comments = "see_comments_post_";

var textareaid = "text_area";
var selectedNewsFeed = "OFFICIAL";

function IS_USER_LOGGED_IN() {
	var status;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/loggedIn",
		cache : false,
		async : false,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			status = 1;
		},
		error : function(data, textStatus, xhr) {
			status = 0;
		}
	});
	return status;
}

function isPageLoaded(array, page) {
	for (var i = 0; i < array.length; ++i) {
		if (array[i] == page) {
			return true;
		}
	}
	return false;
}

function create_post() {
	var post = {}
	post["title"] = $("#post_title").val();
	post["content"] = CKEDITOR.instances['editor'].getData()
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : POST_URI,
		data : JSON.stringify(post),
		dataType : 'json',
		cache : false,
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

function load_posts(page_number, type) {
	var postsWrapper = get_posts_page_request(POST_URI, page_number, type);
	var posts = postsWrapper['posts'];
	for (var i = 0; i < posts.length; ++i) {
		$("#posts").append(createHtmlPost(posts[i]));
		var addPostCommentsId = "#" + post_comments_container + posts[i].postId;
		$(addPostCommentsId).append(appendCommentsContainer(posts[i].postId));
		connectToPost(posts[i].postId);
	}

	$('#posts img').each(function() {
		if (!$(this).hasClass("notres")) {
			$(this).css("width", "100%");
			$(this).css("height", "280px");
			$(this).css("object-fit", "cover");
		}
	});

	for (var i = 0; i < posts.length; ++i) {
		var current_post = posts[i];
		for (var ci = 0; ci < current_post.comments.length; ++ci) {
			var comment_json = current_post.comments[ci];
			var commentlistid = "#" + post_comments_list + current_post.postId;
			var comment = createComment(comment_json);
			$(commentlistid).append(comment);
		}
	}

	return postsWrapper["nextPage"];
}

function get_posts_page_request(POST_URI, page_number, type) {
	var posts;

	var PAGE_URI = POST_URI + "/" + type + PAGE_URI_PATTERN + page_number;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		async : false,
		url : PAGE_URI,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(csrf_header_name, csrf_token);
		},
		success : function(data, textStatus, xhr) {
			posts = data;
		},
		error : function(data, textStatus, xhr) {

		}
	});
	return posts;
}

function createHtmlPost(post_json) {
	var post_footer_comments = post_comments_container + post_json.postId;
	var post_html = '<div class="newsfeed-post" id="' + post_footer_comments
			+ '">';
	post_html += '<div class="newsfeed-post__content">';
	post_html += '<div class="newsfeed-post__content-title">'
	post_html += '<span>' + post_json.title + '</span>';
	post_html += '<div class="newsfeed-post-social-icons" style="line-height:18px">'
			+ post_json.creationDate + '</div>';
	post_html += '<p class="newsfeed-post-event">ARTICOL</p></div>';// test
	post_html += '<div class="newsfeed-post__content-text">'
			+ post_json.content + '</div></div></div>';
	return post_html;
}

function appendCommentsContainer(post_id) {
	var commentsListId = post_comments_list + post_id;
	var textarea_local_id = textareaid + post_id;
	var comments_list_wrapper_id = comment_list_wrapper + post_id;
	var see_comments_id = see_comments + post_id;
	var comment = '<div class="newsfeed-post__content-footer">'
			+ '<div class="newsfeed-post__author">'
			+ '</div>'
			+ '<span class="newsfeed-post__comments text-right"> <a class="cursor-class" onclick="displayComments('
			+ post_id
			+ ')">'
			+ '<i class="fa fa-comments-o icon-social-thumb" aria-hidden="true"></i><p style="display: inline;" id="'
			+ see_comments_id
			+ '">Vezi comentariile</p></span></a>'
			+ '<div style="display:none" id="'
			+ comments_list_wrapper_id
			+ '"> <div class="actionBox">'
			+ '<ul class="commentList" id="'
			+ commentsListId
			+ '">'
			+ '</ul>'
			+ '</div>'
			+ '<div class="row">'
			+ '<div class="status-upload">';
			
		if(USER_LOGGED_IN == 1) {
			comment += '<div sec:authorize="isAuthenticated()"><form>'
			+ '<textarea placeholder="Comenteaza..." id="'
			+ textarea_local_id
			+ '"></textarea>'
			+ '<button class="btn btn" type="button" onclick="sendComment('
			+ post_id
			+ ')">'
			+ '<i class="fa fa-share">Trimite</i>'
			+ '</button>'
			+ '</form></div>';
		} else if(USER_LOGGED_IN == 0) {
			comment+='<p style="display: block;text-align: center;color: #561018;">Logheaza-te pentru a lasa comentarii</p>';
		}
		comment +='</div></div></div></div>';
	return comment;
}

function createComment(comment) {
	var photoUrl = '/assets/images/nobody.jpg';
	if(comment.userPhotoUrl != "NO_PHOTO") {
		photoUrl = comment.userPhotoUrl;
	}

	var usernameLink = '<a style="color:#561018;font-weight: bold;" href="/profil/' + comment.username + '">'+comment.username+'</a>';
	var comment = '<li>'
			+ '<div class="commenterImage">'
			+ '<img src="'+ photoUrl + '" class="notres"/>'
			+ '</div>' + '<div class="commentText">' + '<p class="">' + comment.text
			+ '</p>' + '<span class="date sub-text">' + 'Postat de '
			+ usernameLink
			+ '</span>' + '</div>' + '</li>';
	return comment;
}

function displayComments(postid) {
	var post_id_comments = "#" + comment_list_wrapper + postid;
	var see_comments_id = "#" + see_comments + postid;
	if ($(post_id_comments).css('display') == 'block') {
		$(post_id_comments).hide(100);
		$(see_comments_id).html("Vezi comentariile")
	} else {
		$(post_id_comments).show(100);
		$(see_comments_id).html("Inchide comentariile")
	}
}

function newsTabsController() {
	
	var officalNewsId = document.getElementById("officialNewsButton");
	var normalNewsId = document.getElementById("normalNewsButton");

	if (officalNewsId.classList.contains('active')) {
		officalNewsId.classList.remove('active');
		normalNewsId.classList.add('active');
		selectedNewsFeed = "NORMAL";
		clearAndLoadPosts();
		return;
	}

	officalNewsId.classList.add('active');
	normalNewsId.classList.remove('active');
	selectedNewsFeed = "OFFICIAL";
	clearAndLoadPosts();
}

function clearAndLoadPosts (){
	document.getElementById("posts").innerHTML = "";
	next_page = 1;
	load_posts(0, selectedNewsFeed);
}

