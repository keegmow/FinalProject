<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.krho.finalproject.Question"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query 5</title>
</head>
<jsp:useBean id="Question" class="com.krho.finalproject.Question">  
</jsp:useBean>  
<jsp:setProperty property="*" name="Question"/>
<body>
<div align="left">
	<h2><c:out value="${Question.prompt5}"></c:out></h2>
	
	<form:form method="post" action="answer5" commandName="activityQuery">
	      Answer:
	      <br>
	      <form:radiobutton path="answer5" value="${Question.choice5a}" label="${Question.choice5a}" />      
		<br>
	      <form:radiobutton path="answer5" value="${Question.choice5b}" label="${Question.choice5b}" />
		<br>
		<input type="submit" value="Submit"/>
        </form:form>

    </div>
</body>
</html>