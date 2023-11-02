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
    <title>About this club</title>
</head>
<body>
	<nav>
		<h1>Student Club Compendium</h1>
		<ul>
			<li><a href="/students">All students</a></li>
			<li><a href="/clubs">All clubs</a></li>
		</ul>
	</nav>
	<h1>About <c:out value="${ thisClub.clubName }"/>:</h1>
	<p>Description: <c:out value="${ thisClub.description }"/></p>
	<p>Enrolled students:</p>
	<ul>
		<c:forEach var="enrolledStudent" items="${ thisClub.enrolledStudents }">
			<li><c:out value="${ enrolledStudent.name }"/>
				<form action="/clubs/removestudent" method="POST">
					<input type="hidden" value="put" name="_method" />
					<input type="hidden" value="${ thisClub.id }" name="clubId"/>
					<input type="hidden" value="${ enrolledStudent.id }" name="studentId"/>
					<input type="submit" class="btn" value="Drop student"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	<p>Add a student:</p>
	<!-- Here is a form that will show all the clubs that this student is NOT enrolled in -->
	<form action="/clubs/addstudent" method="POST">
		<input type="hidden" value="${ thisClub.id }" name="clubId"/>
		<select name="studentId">
			<c:forEach var="thisStudent" items="${ unenrolledStudents }">
				<option value="${ thisStudent.id }"><c:out value="${ thisStudent.name }"/></option>
			</c:forEach>
		</select>
		<input type="submit" class="btn" value="Enroll student" />
	</form>
</body>
</html>