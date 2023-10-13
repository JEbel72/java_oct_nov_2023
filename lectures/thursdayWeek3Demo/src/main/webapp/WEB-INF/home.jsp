<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First form</title>
</head>
<body>
	<h1>Our first form</h1>
	<form action="/handleform" method="POST">
		<label>Favorite team:</label>
		<input type="text" name="team" />
		<label>Favorite song:</label>
		<input type="text" name="song" />
		<label>Favorite number:</label>
		<input type="number" name="number" />
		<label>Brag about yourself:</label>
		<textarea name="brag"></textarea>
		<input type="submit" value="Send"/>
	</form>
</body>
</html>