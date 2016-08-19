<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="/ERS/resource/css/index.css">
</head>
<body>
<c:if test="${session.role.roleId eq 1}">
<ul class="nav nav-pills">
				<li role="presentation"><form action="main.do" method="post"><button type="submit" class="btn btn-warning">Main Page</button></form></li>			
    			<li role="presentation"><form action="admin.do" method="post"><button type="submit" class="btn btn-warning">Admin View</button></form></li>	
  				<li role="presentation"><form action="logout.do" method="post"><button type="submit" class="btn btn-warning">Logout</button></form></li>
			</ul>
</c:if>
<c:if test="${session.role.roleId eq 2}">
	<ul class="nav nav-pills">
				<li role="presentation"><form action="main.do" method="post"><button type="submit" class="btn btn-warning">Main Page</button></form></li>		
  				<li role="presentation"><form action="clientClaim.do" method="post"><button type="submit" class="btn btn-warning">Make Claim</button></form></li>
  				<li role="presentation"><form action="clientView.do" method="post"><button type="submit" class="btn btn-warning">View Status/History</button></form></li>
  				<li role="presentation"><form action="logout.do" method="post"><button type="submit" class="btn btn-warning">Logout</button></form></li>
			</ul>
</c:if>
</body>
</html>