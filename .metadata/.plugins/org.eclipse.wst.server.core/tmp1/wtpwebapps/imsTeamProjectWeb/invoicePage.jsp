<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoices!</title>
</head>
<body>
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
</body>
</html>