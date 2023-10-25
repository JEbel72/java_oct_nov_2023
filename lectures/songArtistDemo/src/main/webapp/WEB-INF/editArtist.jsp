<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- Changed encoding to UTF-8 -->
<%@ page isErrorPage="true" %> <!--  For rendering errors in PUT routes -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- Changed encoding to UTF-8 -->
<title>Edit artist</title>
<link rel="stylesheet" href="/css/formStyles.css" media="all" type="text/css"/>
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
	<h1>Edit artist</h1>
	<form:form action="/artists/${ artistToEdit.id }/edit" modelAttribute="artistToEdit" method="POST">
		<input type="hidden" name="_method" value="put"> <!--  To allow PUT requests -->
		<div>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>
		<div>
			<form:label path="isActive">Is active:</form:label>
			<form:errors path="isActive" />
			<div>			
				<!-- Use a label for the actual text while using true/false for the boolean field -->
				<form:radiobutton path="isActive" value="true" label="Yes"/>
				<form:radiobutton path="isActive" value="false" label="No"/>
			</div>
		</div>
		<div>
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre" />
			<!--  Dropdown with a preset list of music genres -->
			<form:select path="genre" items="${ allGenres }" />
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</div>
		<div>
			<form:label path="isSolo">Is solo:</form:label>
			<form:errors path="isSolo" />
			<div>			
				<!-- Use a label for the actual text while using true/false for the boolean field -->
				<form:radiobutton path="isSolo" value="true" label="Solo"/>
				<form:radiobutton path="isSolo" value="false" label="Group"/>
			</div>
		</div>
		<div>
			<form:label path="memberCount">Member count:</form:label>
			<form:errors path="memberCount" />
			<form:input type="number" path="memberCount" />
		</div>
		<input type="submit" class="btn" value="Edit artist" />
	</form:form>
</body>
</html>