<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose your own adventure!</title>
</head>
<body>
	<h1>Welcome to the story that you will write!</h1>
	<p><c:out value="${ story }"/></p>
	<p><a href="/${ leftRoute }"><c:out value="${ leftText }"/></a> <a href="/${ rightRoute }"><c:out value="${ rightText }"/></a></p>
</body>
</html>