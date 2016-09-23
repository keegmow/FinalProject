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
<title>${Question.prompt2}</title>
</head>
<body>
<div align="left">
	<h2><c:out value="${Question.prompt2}"></c:out></h2>
	
	<form:form method="get" action="answer2" commandName="activityQuery">
	      
	    <br>
	    		<%-- <form:radiobutton path="answer2" value="${Question.choice2a}" label="${Question.choice2a}" /> --%>
	    		<input type="submit" name="answer2" value="${Question.choice2a}" />
	    	<br>
	     	<%-- <form:radiobutton path="answer2" value="${Question.choice2b}" label="${Question.choice2b}" /> --%>
	     	<input type="submit" name="answer2" value="${Question.choice2b}" />
		<br>
		<!-- <input type="submit" value="Submit"/> -->
        </form:form>

    </div>
</body>
</html>