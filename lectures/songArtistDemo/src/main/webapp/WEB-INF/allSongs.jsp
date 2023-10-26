<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- Changed encoding to UTF-8 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- Changed encoding to UTF-8 -->
<title>All songs</title>
<link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs/new">Add a song</a></li>
		</ul>
	</nav>
	<h3>All songs</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Artist/Group</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ allSongs }" var="currentSong">
				<tr>
					<td><c:out value="${ currentSong.id }"/></td>
					<td><c:out value="${ currentSong.title }"/></td>
					<td><c:out value="${ currentSong.recordingArtist.name }"/></td> <!--  Grab name of artist/group -->
					<td><a class="btn" href="/songs/${ currentSong.id }">View</a> <a class="btn" href="/songs/${ currentSong.id }/edit">Edit</a>
					<form action="/songs/${ currentSong.id }/delete" method="POST">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>