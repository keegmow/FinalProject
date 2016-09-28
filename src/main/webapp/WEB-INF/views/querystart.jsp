<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.krho.finalproject.Question"%>
<%@ page import="com.krho.weatherapi.WeatherInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<jsp:useBean id="Question" class="com.krho.finalproject.Question">
</jsp:useBean>
<jsp:setProperty property="*" name="Question" />
<%-- <jsp:useBean id="weather" class="com.krho.weatherapi.WeatherInfo">
</jsp:useBean>
<jsp:setProperty property="*" name="weather" /> --%>
<title><c:out value="${Question.prompt1()}"></c:out></title>
</head>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<body>
	<div align="center">
		<h2>
			<c:out value="${Question.prompt1()}"></c:out>
		</h2>

		<form:form method="get" action="answer1" commandName="activityQuery">

			<br>
			<%-- <form:radiobutton path="answer1" value="${Question.choice1a}" label="${Question.choice1a}" /> --%>
			<input type="submit" class="btn btn-info" name="answer1" value="${Question.choice1a}" />
			<br>
			<%-- <form:radiobutton path="answer1" value="${Question.choice1b}" label="${Question.choice1b}" /> --%>
			<input type="submit" class="btn btn-info" name="answer1" value="${Question.choice1b}" />
			<br>
			<br>
			<input type="submit" class="btn btn-info" name="answer1" value="${Question.supriseMe}" />
			<!-- <input type="submit" value="Submit"/> -->
		</form:form>

		<c:catch>
		<div class="panel panel-default">
			<div class="panel-header">	Weather : ${activityQuery.getWeather().getCityName()}</div>
  				<div class="panel-body">
					${activityQuery.getWeather().getWeatherDescription()}
					<img src="http://openweathermap.org/img/w/${activityQuery.getWeather().getIcon()}.png">
					
					${activityQuery.getWeather().getWeatherInF()}
					
					Low: ${activityQuery.getWeather().getLowTemp()} High:
					${activityQuery.getWeather().getHighTemp()}<br /> Wind Speed:
					${activityQuery.getWeather().getWindSpeed()} <br />
				</div>
			</div>
		</c:catch>

	</div>
</body>
</html>