<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>

		<!-- FONT -->
		<link href='https://fonts.googleapis.com/css?family=Crimson+Text' rel='stylesheet' type='text/css'>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="/ERS/resource/css/index.css">
</head>
<body>
	<div class="container header .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/headerPage/header.jsp"></jsp:include>
	</div>
	<br />
	
	<div class="container main .col-xs-12 .col-sm-6 .col-lg-8">
		<h1 class="h1-error">Something went wrong...</h1>
		<div class="imgDiv">
			<img src="/ERS/resource/images/desk_flip.png"/>
		</div>	
	</div>
	<br />
	
	<div class="container footer .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/footerPage/footer.jsp"></jsp:include>
	</div>
	<br />
	
</body>
</html>