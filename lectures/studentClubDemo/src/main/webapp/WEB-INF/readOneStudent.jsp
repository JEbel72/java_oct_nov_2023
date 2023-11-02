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
    <link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
    <title>About this student</title>
</head>
<body>
	<nav>
		<h1>Student Club Compendium</h1>
		<ul>
			<li><a href="/students">All students</a></li>
			<li><a href="/clubs/new">Add a club</a></li>
		</ul>
	</nav>
	<h1>About <c:out value="${ thisStudent.name }"/>:</h1>
	<p>Birth date: <c:out value="${ thisStudent.birthdate }"/></p>
	<p>Enrolled clubs:</p>
	<ul>
	<!-- CHALLENGE: Figure out how to show "No clubs joined" if the student is not in any clubs -->
		<c:forEach var="enrolledClub" items="${ thisStudent.enrolledClubs }">
			<li><c:out value="${ enrolledClub.clubName }"/>
				<!-- Anchor tag that was added during lecture to demo removing a student from club -->
				<form action="/students/removeclub" method="POST">
					<input type="hidden" value="put" name="_method" /> <!-- Added after lecture -->
					<input type="hidden" value="${ thisStudent.id }" name="studentId"/>
					<input type="hidden" value="${ enrolledClub.id }" name="clubId"/>
					<input type="submit" class="btn" value="Leave club"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	<p>Add a club:</p>
	<!-- Here is a form that will show all the clubs that this student is NOT enrolled in -->
	<!-- CHALLENGE: Figure out how to NOT show the form if the student joined all clubs -->
	<form action="/students/addclub" method="POST">
		<input type="hidden" value="${ thisStudent.id }" name="studentId"/>
		<select name="clubId">
			<c:forEach var="thisClub" items="${ unjoinedClubs }">
				<option value="${ thisClub.id }"><c:out value="${ thisClub.clubName }"/></option>
			</c:forEach>
		</select>
		<input type="submit" class="btn" value="Enroll in club" />
	</form>
</body>
</html>