<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> <!--  For rendering errors in PUT routes -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit artist</title>
</head>
<body>
	<a href="/artists">All artists</a>
	<h1>Edit artist</h1>
	<form:form action="/artists/${ artistToEdit.id }/edit" modelAttribute="artistToEdit" method="POST">
		<input type="hidden" name="_method" value="put"> <!--  To allow PUT requests -->
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
			<form:radiobutton path="isSolo" value="true" label="Solo"/>
			<form:radiobutton path="isSolo" value="false" label="Group"/>
		</p>
		<p>
			<form:label path="memberCount">Member count:</form:label>
			<form:errors path="memberCount" />
			<form:input type="number" path="memberCount" />
		</p>
		<input type="submit" value="Edit artist" />
	</form:form>
</body>
</html>