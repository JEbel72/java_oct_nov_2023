<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About ${ thisArtist.name }</title>
</head>
<body>
	<a href="/artists">All artists</a>
	<h1>About <c:out value="${ thisArtist.name }"/></h1>
	<p>Genre: <c:out value="${ thisArtist.genre }"/></p>
	<p>Description: <c:out value="${ thisArtist.description }"/></p>
	<p>
		<c:choose>
			<c:when test="${ thisArtist.isSolo }">
				<c:out value="${ thisArtist.name }" /> is a solo artist.
			</c:when>
			<c:otherwise>
				<c:out value="${ thisArtist.name }" /> is a band with <c:out value="${ thisArtist.memberCount }" /> members.
			</c:otherwise>
		</c:choose>
	</p>
	<p>
		<c:choose>
			<c:when test="${ thisArtist.isActive }">
				<c:out value="${ thisArtist.name }" /> is active.
			</c:when>
			<c:otherwise>
				<c:out value="${ thisArtist.name }" /> is not active.
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>