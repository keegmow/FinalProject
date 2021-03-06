<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.krho.finalproject.Question"%>
<%@ page import="com.krho.weatherapi.WeatherInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0049)http://v4-alpha.getbootstrap.com/examples/cover/# -->
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
	<link rel="icon" href='resources/e.png'>

    <!-- Bootstrap core CSS -->
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

    <!-- Custom styles for this template -->
    <link href="resources/Cover Template for Bootstrap_files/cover.css" rel="stylesheet">
    
    <jsp:useBean id="Question" class="com.krho.finalproject.Question"></jsp:useBean>
	<jsp:setProperty property="*" name="Question" />
	
    <title>Embark: Location</title>
  </head>

  <body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Embark</h3>
						<nav class="nav nav-masthead"> 
						<a class="nav-link" href="./">Home</a>
						<a class="nav-link active" href="location">New Location</a> 
						<a class="nav-link" href="zipcode">New Query</a>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Please enter your<br>zip code</h1>
					<br>
					<h3>
						We need your location.<br>

					</h3>
					<br>
					<div align="center">

						<form:form method="get" action="zipcode"
							commandName="activityQuery">

							<h5>Zip code:</h5>
							<form:input type="text" id="ex1" path="zipcode" size="5"
								placeholder="" class="form-control" />
							<form:errors path="zipcode" cssClass="error" />
							<br>
							<input type="submit" value="Enter"
								class="btn btn-lg btn-secondary" />
						</form:form>
					</div>

					<br>

				</div>



			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/Cover Template for Bootstrap_files/jquery.min.js" integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="resources/Cover Template for Bootstrap_files/tether.min.js" integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB" crossorigin="anonymous"></script>
    <script src="resources/Cover Template for Bootstrap_files/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="resources/Cover Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>
  

</body>
</html>