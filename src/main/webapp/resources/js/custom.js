var showHideDuration = 250;
function showOverlay(image) {
	$index = $(image).data("list-index");
	$.ajax({
		url : 'increase-image-views',
		type : 'post',
		contentType : 'application/x-www-form-urlencoded',
		data : {
			index : $index
		},
		dataType : 'json',
		success : function(data, textStatus, jQxhr) {
			$(image).find("span").html(data + " views");
		},
		error : function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	$("#overlay-image img").attr("src", $(image).find("img").attr("src"));
	$("#overlay").show(showHideDuration);
};

function hideOverlay() {
	$("#overlay").hide(showHideDuration);
};

$(document).on('keydown', function(e) {
	if (e.keyCode === 27) { // ESC
		$(overlay).hide(showHideDuration);
	}
});