<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Claim</title>
		
		<!-- FONT -->
		<link href='https://fonts.googleapis.com/css?family=Crimson+Text' rel='stylesheet' type='text/css'>
	
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<!-- jQuery -->
		<script src="/ERS/resource/js/jquery-3.1.0.js"></script>
		<!-- JavaScript -->
		<script type="text/javascript" src="/ERS/resource/js/addClaim.js"></script>
		<link rel="stylesheet" href="resource/css/index.css">
		

</head>
<body>
	<div class="container header .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/headerPage/header.jsp"></jsp:include>
	</div>
	
	<br />
	
	<div class="container nav .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/navPage/nav.jsp"></jsp:include>
	</div>
	
	<br />
	
	<div class="container main .col-xs-12 .col-sm-6 .col-lg-8">
	<br />
	<form action="addClaim.do" method="post">
		<table class="claim" id="myTable">
			<tr>
				<td>Reimbursement Amount:</td>
				<td><input type="text" class="form-control" id="amount" name="amount" /></td>
				<span id="amountV"></span>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea type="text" class="form-control" id="desc" name="desc" rows="5"></textarea></td>
				
			</tr>
			<tr>
				<td>Reimbursement Type:</td>
				<td>
					<select name="type" class="form-control" >
						<c:forEach var="t" items="${type}">
							<option value="${t.typeId}">
								<c:out value="${t.type}"></c:out>
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<input id="addBtn" type="submit" class="btn btn-warning" disabled/>
				</td>
			</tr>
		</table>
	</form>
		
	</div>
	
	<br />
	<span id="descV"></span>
	
	
	<div class="container footer .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/footerPage/footer.jsp"></jsp:include>
	</div>
	
	<br />
</body>
</html>