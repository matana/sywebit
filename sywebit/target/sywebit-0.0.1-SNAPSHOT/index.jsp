<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Syntax controlled Web Editor - sywebit</title>
</head>
<body>

	<textarea name="token" id="token_text_area" style="width: 800px; height: 100px">data { token: enter some text...}</textarea>
	<button id="submission" type="submit">submit</button>
	<div id="server_message" style="width: 800px; height: 100px; border: 1px solid #000;"></div>
	
</body>
</html>