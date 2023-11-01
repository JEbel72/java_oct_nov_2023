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
	<title>Add club page</title>
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
	<h3>Add a club:</h3>
	<!-- Watch your modelAttribute name - must match @ModelAttribute name inside quotes EXACTLY -->
	<form:form action="/clubs/new" method="POST" modelAttribute="newClub">
		<div>
			<form:label path="clubName">Club Name:</form:label>
			<form:errors path="clubName"/>
			<form:input path="clubName"/>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</div>
		<input type="submit" class="btn" value="Add club" />
	</form:form>
</body>
</html>