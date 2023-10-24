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
	<h3>All song</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Attributes - including who sang the song - go here!</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			FIGURE OUT HOW TO LOOP THROUGH EACH SONG HERE!
		</tbody>
	</table>
</body>
</html>