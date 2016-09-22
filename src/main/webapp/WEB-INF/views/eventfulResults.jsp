<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ page import="com.krho.finalproject.Eventful"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eventful Results</title>
</head>
<h1>Event Results</h1>
<body>
<c:forEach var="i" items="${results}">
<c:out value="${i.getTitle()} "/><p>
<c:out value="${i.getStartTime()}"/><p>
<c:out value="${i.getVenue().getName()}"/><p>
<c:out value="${i.getCategories().getName()}"/><p>
<c:out value="${i.getURL()}"/><p>
</c:forEach>
</body>
</html>