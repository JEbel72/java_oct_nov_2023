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
	<title>Add student page</title>
	<link rel="stylesheet" href="/css/formStyles.css" media="all" type="text/css"/>
</head>
<body>
	<nav>
		<h1>Student Club Compendium</h1>
		<ul>
			<li><a href="/students">All students</a></li>
			<li><a href="/clubs">All clubs</a></li>
		</ul>
	</nav>
	<h3>Add a student:</h3>
	<!-- Watch your modelAttribute name - must match @ModelAttribute name inside quotes EXACTLY -->
	<form:form action="/students/new" method="POST" modelAttribute="newStudent">
		<div>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="birthdate">Birthdate:</form:label>
			<form:errors path="birthdate"/>
			<form:input type="date" path="birthdate"/>
		</div>
		<input type="submit" class="btn" value="Add student" />
	</form:form>
</body>
</html>