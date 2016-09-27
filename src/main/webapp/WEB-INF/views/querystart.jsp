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
<jsp:useBean id="Question" class="com.krho.finalproject.Question">
</jsp:useBean>
<jsp:setProperty property="*" name="Question" />
<%-- <jsp:useBean id="weather" class="com.krho.weatherapi.WeatherInfo">
</jsp:useBean>
<jsp:setProperty property="*" name="weather" /> --%>
<title>${Question.prompt1}</title>
</head>
<body>
	<div align="center">
		<h2>
			<c:out value="${Question.getPrompt1()}"></c:out>
		</h2>

		<form:form method="get" action="answer1" commandName="activityQuery">

			<br>
			<%-- <form:radiobutton path="answer1" value="${Question.choice1a}" label="${Question.choice1a}" /> --%>
			<input type="submit" name="answer1" value="${Question.choice1a}" />
			<br>
			<%-- <form:radiobutton path="answer1" value="${Question.choice1b}" label="${Question.choice1b}" /> --%>
			<input type="submit" name="answer1" value="${Question.choice1b}" />
			<br>
			<br>
			<input type="submit" name="answer1" value="${Question.supriseMe}" />
			<!-- <input type="submit" value="Submit"/> -->
		</form:form>

	</div>
	<div align="center">
		<c:catch>
			<h2>${activityQuery.getWeather().getCityName()}:	${activityQuery.getWeather().getWeatherDescription()}</h2>
			<img src="http://openweathermap.org/img/w/${activityQuery.getWeather().getIcon()}.png">
			<h3>
			${activityQuery.getWeather().getWeatherInF()}
			</h3>
			Low: ${activityQuery.getWeather().getLowTemp()} High:
			${activityQuery.getWeather().getHighTemp()}<br /> Wind Speed:
			${activityQuery.getWeather().getWindSpeed()} <br />
		</c:catch>
	</div>

</body>
</html>