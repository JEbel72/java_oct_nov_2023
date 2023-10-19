<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Artist Page</title>
</head>
<body>
	<h1>New artist</h1>
	<!-- Watch your modelAttribute name - must match @ModelAttribute name inside quotes EXACTLY -->
	<form:form action="/artists/new" method="POST" modelAttribute="newArtist">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="isActive">Is active:</form:label>
			<form:errors path="isActive" />
			<!-- Use a label for the actual text while using true/false for the boolean field -->
			<form:radiobutton path="isActive" value="true" label="Yes"/>
			<form:radiobutton path="isActive" value="false" label="No"/>
		</p>
		<p>
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre" />
			<!--  Dropdown with a preset list of music genres -->
			<form:select path="genre" items="${ allGenres }" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<p>
			<form:label path="isSolo">Is solo:</form:label>
			<form:errors path="isSolo" />
			<!-- Use a label for the actual text while using true/false for the boolean field -->
			<form:radiobutton path="isSolo" value="true" label="Yes"/>
			<form:radiobutton path="isSolo" value="false" label="No"/>
		</p>
		<p>
			<form:label path="memberCount">Member count:</form:label>
			<form:errors path="memberCount" />
			<form:input type="number" path="memberCount" />
		</p>
		<input type="submit" value="Add artist" />
	</form:form>
</body>
</html>