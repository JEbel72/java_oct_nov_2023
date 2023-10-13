<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results from our form</title>
</head>
<body>
	<p>Team: <c:out value="${ teamName }"/></p>
	<p>Favorite song: <c:out value="${ favSong }"/></p>
	<p>Favorite number: <c:out value="${ number }"/></p>
	<p>Brag: <c:out value="${ brag }"/></p>
</body>
</html>