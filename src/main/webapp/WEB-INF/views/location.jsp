<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Location</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
<div align="center">
<h1>Please enter you zipcode</h1>
We need your location.
<br>
Please type in your zipcode.

	<form:form method="get" action="zipcode" commandName="activityQuery">
		Zipcode:
      		<form:input path="zipcode" size="5" placeholder="00000"/>
      		<form:errors path="zipcode" cssClass="error"/>
      		<br>
      		<input type="submit" value="Enter"/>
	</form:form>
</div>
</body>
</html>