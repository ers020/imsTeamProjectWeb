<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoices!</title>
	<!-- BootStrap -->
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
	<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
	
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	
	<!-- CSS Google Text -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,900" rel="stylesheet" type="text/css">
	
	<!-- Custom CSS -->
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/index.css">

</head>
<body>

	<div class="container main .col-xs-12 .col-sm-6 .col-lg-8">

	<div class="container header .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/headerPage/header.jsp"></jsp:include>
	</div>
	
	<div class="container nav .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/navPage/nav.jsp"></jsp:include>
	</div>
	<br />
	<div class="container body .col-xs-12 .col-sm-6 .col-lg-8">
	<div>
		<table id="invoiceTable">
			<tr>
		    <th>ID</th>
		    <th>Name</th>
		    <th>Email</th>
		    <th>Address</th>
		    <th>Type</th>
		    <th>Status</th> <!-- MAYBE.  This column can list active/terminated.  MAYBE. -->
		    <th></th>
		  </tr>
		  <c:forEach var="c" items="${clients}">
		  	<tr>
		  		<td><c:out value="${c.clientId}"></c:out></td>
		  		<td><c:out value="${c.clientId}"></c:out></td>
		  		<td><c:out value="${c.clientId}"></c:out></td>
		  	</tr>
		  </c:forEach>
		</table>
	</div>
	</div>
	<br />
	
	<div class="container footer .col-xs-12 .col-sm-6 .col-lg-8">
		<jsp:include page="/footerPage/footer.jsp"></jsp:include>
	</div>
	<br />
</div>
</body>
</html>