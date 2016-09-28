<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ page import="com.krho.finalproject.MovieController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Movies Showtimes</h1>
	<br />
	<c:forEach var="i" items="${movies }">
	<br />
		<h2><a href="<c:out value="${i.getOfficialUrl() }"/>"><c:out value="${i.getTitle()} "/></a></h2>
		<!--  <h2><c:out value="${i.getTitle()} "/></h2> -->
		<h3>Release Date: </h3> 
			<c:out value="${i.getReleaseDate() }"/>
		<h3>Description: </h3> 
			<c:out value="${i.getLongDescription() }"/>
		<h3>Genres: </h3> 
		<c:forEach var="j" items="${i.getGenres() }">
			<c:out value="${j }"/>
			</c:forEach>
		<h3>TopCast: </h3> 
			<c:forEach var="j" items="${i.getTopCast() }">
			<c:out value="${j }"/>
			</c:forEach>
		<h3>Showtimes: </h3> 
			<c:forEach var="j" items="${i.getShowtimes() }">
			<c:out value="${j }"/><br />
			</c:forEach> 
	</c:forEach>

</body>
</html>
