<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- Changed encoding to UTF-8 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- Changed encoding to UTF-8 -->
<title>All artists and groups</title>
<link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
</head>
<body>
	<!-- Added nav bar and links, and moved add artist link up -->
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists/new">Add artist</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h3>All artists and groups</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Genre</th>
				<th>Is solo or group</th>
				<th>Number of songs</th>
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
					<td><c:out value="${ thisArtist.songs.size() }"/></td>
					<td><a class="btn" href="/artists/${ thisArtist.id }">View</a> <a class="btn" href="/artists/${ thisArtist.id }/edit">Edit</a>
						<form action="/artists/${ thisArtist.id }/delete" method="POST">
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