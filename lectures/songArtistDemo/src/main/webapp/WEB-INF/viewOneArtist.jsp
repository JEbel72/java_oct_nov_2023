<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- Changed encoding to UTF-8 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- Changed encoding to UTF-8 -->
<title>About ${ thisArtist.name }</title>
<link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
</head>
<body>
	<!-- Added nav bar and links and moved all artists link up -->
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h3>About <c:out value="${ thisArtist.name }"/></h3>
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
	<p>ADD SONGS by this artist/group here!!!</p>
</body>
</html>