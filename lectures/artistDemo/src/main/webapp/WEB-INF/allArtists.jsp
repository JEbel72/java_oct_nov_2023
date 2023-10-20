<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All artists and groups</title>
</head>
<body>
	<a href="/artists/new">Add artist</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Genre</th>
				<th>Is solo or group</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<!-- Loop through each artist from the database -->
			<c:forEach var="thisArtist" items="${ allArtists }">
				<tr>
					<td><c:out value="${ thisArtist.id }"/></td>
					<td><c:out value="${ thisArtist.name }" /></td>
					<td><c:out value="${ thisArtist.genre }" /></td>
					<td>
						<c:choose>
							<c:when test="${ thisArtist.isSolo == true }">
								Solo
							</c:when>
							<c:otherwise>
								Group
							</c:otherwise>
						</c:choose>
					</td>
					<td><a href="/artists/${ thisArtist.id }">View</a> <a href="/artists/${ thisArtist.id }/edit">Edit</a>
						<form action="/artists/${ thisArtist.id }/delete" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>