$(function() {
	addSubmitHandler();
});

function addSubmitHandler() {
	$("#submission").bind('click', function(event) {
		var token = $('textarea#token_text_area').val();
		validateToken(token);
	});
}

function validateToken(token) {
	if (token !== null) {
		$.ajax({
			type : 'POST',
			url : '/editor/validate',
			data : {
				token : token
			},
			success : function(data) {
				console.log(data);
				$('#server_message').text(data);
				// $.getJSON('/server_message', function(data) {
				// var items = [];
				// $.each( data, function( key, val ) {
				// items.push( "<li id='" + key + "'>" + val + "</li>" );
				// });
				// $( "<ul/>", {
				// "class": "my-new-list",
				// html: items.join( "" )
				// }).appendTo( "body" );
				// });
			},
			error : function(xhr, status, error) {
				alert("Someting went wrong... " + error);
			}
		});
	}
}