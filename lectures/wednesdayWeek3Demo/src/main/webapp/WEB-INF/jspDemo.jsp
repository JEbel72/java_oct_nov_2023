<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> <!-- Needed for our JSTL tags!! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP demo</title>
<link rel="stylesheet" type="text/css" href="/css/myStyles.css"> <!--  Linking CSS in our static folder  -->
</head>
<body>
	<h1><c:out value="${ pageTitle }" /></h1> <!-- Displaying data from the server -->
	<!-- Note this is like the enhanced for loop -->
	<c:forEach var="thisShow" items="${ allShows }">
		<c:choose> <!-- Demo if-else clause using c:choose, c:when and c:otherwise tags -->
			<c:when test="${ thisShow.equals('Game of Thrones') }">
				<p><c:out value="${ thisShow }"/> has great writing!</p>
			</c:when>
			<c:otherwise>
				<p><c:out value="${ thisShow }"/></p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>