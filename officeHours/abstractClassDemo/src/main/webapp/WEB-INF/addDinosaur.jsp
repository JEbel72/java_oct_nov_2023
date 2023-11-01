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
    <title>Add dinosaur</title>
</head>
<body>
	<form:form modelAttribute="newDino" method="POST" action="/add">
		<p>
			<form:label path="numberOfLegs">Number of legs</form:label>
			<form:input type="number" path="numberOfLegs"/>
		</p>
		<p>
			<form:label path="isPlantEater">Is plant eater</form:label>
			<form:checkbox path="isPlantEater"/>
		</p>
		<p>
			<form:label path="isMeatEater">Is meat eater</form:label>
			<form:checkbox path="isMeatEater"/>
		</p>
		<p>
			<form:label path="height">Height</form:label>
			<form:input type="number" path="height"/>
		</p>
		<p>
			<form:label path="species">Species</form:label>
			<form:input path="species"/>
		</p>
		<input type="submit" value="Add dinosaur"/>
	</form:form>
</body>
</html>