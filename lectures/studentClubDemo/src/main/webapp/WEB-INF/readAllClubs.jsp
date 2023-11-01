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
	<title>All clubs page</title>
	<link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
</head>
<body>
	<nav>
		<h1>Student Club Compendium</h1>
		<ul>
			<li><a href="/students">All students</a></li>
			<li><a href="/clubs/new">Add a club</a></li>
		</ul>
	</nav>
	<h3>All clubs</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisClub" items="${ allClubs }">
				<tr>
					<td><c:out value="${ thisClub.id }"/></td>
					<td><c:out value="${ thisClub.clubName }"/></td>
					<td><a class="btn" href="/clubs/${ thisClub.id }">View</a> <a class="btn" href="/clubs/${ thisClub.id }/edit">Edit</a>
						<form action="/clubs/${ thisClub.id }/delete" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" class="btn-delete" value="Delete"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>