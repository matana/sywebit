<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Syntax controlled Web Editor - sywebit</title>
</head>
<body>
	<h3>Editor</h3>
	<textarea name="entry" id="entry_text_area"
		style="width: 800px; height: 150px; max-width: 800px; min-width: 800px;"></textarea>
	<br>
	<button id="push" type="submit">submit</button>
	<h3>Validation Message</h3>
	<div id="server_message"
		style="width: 800px; height: 150px; border: 1px solid #000; overflow: scroll; position: absolute;"></div>

</body>
</html>