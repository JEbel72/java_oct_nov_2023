<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit song</title>
	<link rel="stylesheet" href="/css/formStyles.css" media="all" type="text/css"/>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h1>Edit song</h1>
	<!-- Fill out attributes for form here, and add inputs!!! -->
	<form:form action="/songs/${ editedSong.id }/edit" modelAttribute="editedSong" method="POST">
		<input type="hidden" name="_method" value="put"> <!-- To allow PUT requests -->
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</div>
		<div>
			<form:label path="releaseDate">Release date:</form:label>
			<form:errors path="releaseDate"/>
			<form:input type="date" path="releaseDate"/>
		</div>
		<div>
			<form:label path="isExplicit">Has explicit lyrics:</form:label>
			<form:errors path="isExplicit"/>
			<div>
				<form:radiobutton path="isExplicit" value="true" label="Yes"/>
				<form:radiobutton path="isExplicit" value="false" label="No"/>
			</div>
		</div>
		<div>
			<form:label path="lyrics">Some lyrics:</form:label>
			<form:errors path="lyrics"/>
			<form:textarea path="lyrics" />
		</div>
		<div>
			<form:label path="recordingArtist">Artist/group:</form:label>
			<form:errors path="recordingArtist"/>
			<form:select path="recordingArtist">
			<!-- Display all options at once - we need the ID of the artist for the value (itemValue), and the name of the artist will be the text we see (itemLabel) -->
				<form:options items="${ allArtists }" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
		<input type="submit" class="btn" value="Edit song" />
	</form:form>
</body>
</html>