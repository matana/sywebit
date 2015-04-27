$(function() {
	addSubmitHandler();
});

function addSubmitHandler() {
	$("#push").bind('click', function(event) {
		var entry = $('textarea#entry_text_area').val();
		validateToken(entry);
		event.preventDefault();
	});
}

function validateToken(entry) {
	if (entry !== null) {
		$.ajax({
			type : 'POST',
			url : '/editor/validate',
			data : {
				entry : entry
			},
			success : function(result) {
				var items = [];
				$.each(result, function(key, val) {
					if (typeof val === 'object' && notEmpty(val)) {
						for (var i = 0; i < val.length; i++) {
							items.push("<p class='error'>" + val[i] + "</p>");
						}
						// items.push(key + ": " + JSON.stringify(val));
						console.log(val);
					} else {
						// items.push(key + ": " + val);
					}
				});
				console.log(items);
				if(notEmpty(items) && items.length > 0)
					$('#server_message').html(items);
				else
					$('#server_message').html("<p class='success'>Input is valid!</p>");
			},
			error : function(xhr, status, error) {
				$('#server_message').text("xhr: " + xhr);
				$('#server_message').text("status: " + status);
				$('#server_message').text("error: " + error);
			}
		});
	}
}

function notEmpty(obj) {
	return obj && obj !== "null" && obj !== "undefined";
}