<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.krho.finalproject.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
<div align="center">
	<form:form method="get" action="activityChoice" commandName="">
		<c:forEach items="${finalQuery}" var="act" end="5">
    			<td><input type="submit" name="activityParam" value="${act.getActivityName()}" /></td><br>
		</c:forEach>
		<br>
		<c:if test="${finalQuery.size() > 5}">
		<input type="button" value="More Ideas" onClick="window.location.reload()">
		</c:if>
		
	</form:form>


</div>
</body>
</html>