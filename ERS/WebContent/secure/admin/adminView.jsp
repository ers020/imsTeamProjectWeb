<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View</title>

		<!-- FONT -->
		<link href='https://fonts.googleapis.com/css?family=Crimson+Text' rel='stylesheet' type='text/css'>

		<!-- Datatables CSS CDN -->
		<link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel='stylesheet' type='text/css' >

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		
		<!-- jQuery -->
		<script src="/ERS/resource/js/jquery-3.1.0.js"></script>
		
		<!-- Custom CSS -->
		<link rel="stylesheet" href="/resource/css/index.css">
		
		<!-- jQuery DataTable -->
		<script src="/ERS/resource/js/jquery.dataTables.min.css"></script>
		<script src="/ERS/resource/js/jquery.dataTables.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#myTable").DataTable();
			});
		
		</script>
		

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
		<table id="myTable" class="table table-hover">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Reimbursement Amount</th>
				<th>Reimbursement Description</th>
				<th>Reimbursement Status</th>
				<th>Reimbursement Type</th>
				<th>Approve</th>
				<th>Deny</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${reimbs}">
			<tr>
				<td><c:out value="${item.author.fName}" ></c:out></td>
				<td><c:out value="${item.author.lName}" ></c:out></td> 
				<td><fmt:formatNumber value="${item.amount}" type="currency"></fmt:formatNumber></td>
				<td><c:out value="${item.desc}" ></c:out></td>
				<td><c:out value="${item.status.status}" ></c:out></td>
				<td><c:out value="${item.type.type}" ></c:out></td>
				<c:choose>
					<c:when test="${item.status.status eq 'PENDING'}"> 
						<td>
							<form action="approveEntry.do" method="post">
								<input type="hidden" name="id" value="${item.id}">
								<button type="submit" class="btn btn-warning">Approve</button>
							</form>
						</td>
						<td>
							<form action="denyEntry.do" method="post">
								<input type="hidden" name="id" value="${item.id}">
								<button type="submit" class="btn btn-warning">Deny</button>
							</form>
						</td>
					</c:when>
					<c:otherwise>
						<td>N/A</td>
						<td>N/A</td>
					</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<br />
	
	<div class="container footer .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/footerPage/footer.jsp"></jsp:include>
	</div>
	
	<br />
</body>
</html>