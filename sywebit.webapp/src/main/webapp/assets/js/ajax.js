$(function() {
<<<<<<< HEAD
	addSubmitHandler();
});

function addSubmitHandler() {
	$("#push").bind('click', function(event) {
		var entry = $('textarea#entry_text_area').val();
		validateToken(entry);
=======
	
	addSubmitHandler();
	addInputChangedListener();
	
});

function addSubmitHandler() {
	$("#push").bind("click", function(event) {
		var entry = $("textarea#entry_text_area").val();
		validateInput(entry, "POST");
>>>>>>> d53ed3f88913c2ac000b50ab9e5c2d627812198a
		event.preventDefault();
	});
}

<<<<<<< HEAD
function validateToken(entry) {
	if (entry !== null) {
		$.ajax({
			type : 'POST',
			url : '/editor/validate',
=======
function addInputChangedListener() {
	$("#entry_text_area").bind("keyup change", function(e) {
		var entry = $(this).val();
		validateInput(entry, "GET");
	});
}

function validateInput(entry, method) {
	if (notEmpty(entry) && length(entry)) {
		$.ajax({
			type : method,
			url : "/editor/validate",
>>>>>>> d53ed3f88913c2ac000b50ab9e5c2d627812198a
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
<<<<<<< HEAD
						// items.push(key + ": " + JSON.stringify(val));
						console.log(val);
					} else {
						// items.push(key + ": " + val);
					}
				});
				console.log(items);
=======
					}
				});
				
>>>>>>> d53ed3f88913c2ac000b50ab9e5c2d627812198a
				if(notEmpty(items) && items.length > 0)
					$('#server_message').html(items);
				else
					$('#server_message').html("<p class='success'>Input is valid!</p>");
			},
			error : function(xhr, status, error) {
<<<<<<< HEAD
				$('#server_message').text("xhr: " + xhr);
				$('#server_message').text("status: " + status);
				$('#server_message').text("error: " + error);
			}
		});
	}
}

function notEmpty(obj) {
	return obj && obj !== "null" && obj !== "undefined";
=======
				$('#server_message').text("xhr: " + xhr + "\n" + "status: " + status + "\n" + "error: " + error);
			}
		});
	} else {
		clearServerMessageBox();
	}
}
function clearServerMessageBox() {
	$('#server_message').empty();
}

function notEmpty(obj) {
	return obj && obj !== "null" && obj !== "undefined";
}

function length(obj) {
	return obj.length > 0 || obj !== "";
>>>>>>> d53ed3f88913c2ac000b50ab9e5c2d627812198a
}