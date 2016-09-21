<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.krho.finalproject.Question"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query 1</title>
</head>
<jsp:useBean id="Question" class="com.krho.finalproject.Question">  
</jsp:useBean>  
<jsp:setProperty property="*" name="Question"/>
<body>
<div align="left">
	<h2><c:out value="${Question.prompt1}"></c:out></h2>
	
	<form:form method="post" action="answer1" commandName="activityQuery">
	      Answer:
	    <br>
	      <form:radiobutton path="answer1" value="${Question.choice1a}" label="${Question.choice1a}" />
	    <br>
	      <form:radiobutton path="answer1" value="${Question.choice1b}" label="${Question.choice1b}" />
		<br>
		<input type="submit" value="Submit"/>
        </form:form>

    </div>
</body>
<FORM NAME="form1" METHOD="POST">
            <INPUT TYPE="HIDDEN" NAME="buttonName">
            <INPUT TYPE="BUTTON" VALUE="Button 1" ONCLICK="button1()">
            <INPUT TYPE="BUTTON" VALUE="Button 2" ONCLICK="button2()">
        </FORM>

        <SCRIPT LANGUAGE="JavaScript">
            
            function button1()
            {
                document.form1.buttonName.value = "button 1"
                form1.submit()
            }    
            function button2()
            {
                document.form1.buttonName.value = "button 2"
                form1.submit()
            }    
            function button3()
            {
                document.form1.buttonName.value = "button 3"
                form1.submit()
            }   
            
        </SCRIPT>
</html>