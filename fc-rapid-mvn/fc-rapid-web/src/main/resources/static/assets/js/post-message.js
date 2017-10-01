$(document).ready(function(){
	$(".post-message").on("click", function(){
		var postDisplay = $(".post-message-area").css("display");
		if (postDisplay != "none") {
			$(".post-message-area").slideUp();
		}
		else {
			$(".post-message-area").slideDown();
			
			if ($( window ).width() > 768) {
				$(".body").addClass("overflow-hidden");
				$(".overlay").show();
			}
		}
	})

	$('.overlay').on("click", function (event) {
		var postDisplay = $(".post-message-area").css("display");
		if (postDisplay != "none") {
			if(!$(event.target).closest('.post-message-area').length && !$(event.target).is('.post-message-area')) {
				$(".overlay").hide();
				$(".post-message-area").slideUp();
				if ($( window ).width() > 768) {
					$(".body").removeClass("overflow-hidden");
				}
			}	
		}
	});
	
});

function closePostEditor() {
	var postDisplay = $(".post-message-area").css("display");
	if (postDisplay != "none") {
		$(".overlay").hide();
		$(".post-message-area").slideUp();
		if ($(window).width() > 768) {
			$(".body").removeClass("overflow-hidden");
		}
	}
}

function openEditor(){ 
	var postDisplay = $(".post-message-area").css("display");
	if (postDisplay != "none") {
		$(".post-message-area").slideUp();
	}
	else {
		$(".post-message-area").slideDown();
		
		if ($( window ).width() > 768) {
			$(".body").addClass("overflow-hidden");
			$(".overlay").show();
		}
	}
}
