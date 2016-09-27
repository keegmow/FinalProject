<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.krho.finalproject.Question"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="Question" class="com.krho.finalproject.Question">  
</jsp:useBean>  
<jsp:setProperty property="*" name="Question"/>
<title>${Question.prompt4}</title>
</head>
<body>
<div align="center">
	<h2><c:out value="${Question.prompt4}"></c:out></h2>
	
	<form:form method="get" action="answer4" commandName="activityQuery">
	     
	    <br>
	      <%-- <form:radiobutton path="answer4" value="${Question.choice4a}" label="${Question.choice4a}" /> --%>
	      <input type="submit" name="answer4" value="${Question.choice4a}" />      
		<br>
	      <%-- <form:radiobutton path="answer4" value="${Question.choice4b}" label="${Question.choice4b}" /> --%>
	      <input type="submit" name="answer4" value="${Question.choice4b}" />
	    <br>
	      <%-- <form:radiobutton path="answer4" value="${Question.choice4c}" label="${Question.choice4c}" /> --%>
	      <input type="submit" name="answer1" value="${Question.choice4c}" />
	    <br>
		<!-- <input type="submit" value="Submit"/> -->
        </form:form>
		<a href="location">
		<button type="button">Change Zipcode</button>
		</a>
		<a href="zipcode">
		<button type="button">New Search</button>
		</a>
    </div>
</body>
</html>