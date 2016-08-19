<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty success}">
	<c:out value="${success}"></c:out>
</c:if>
<br />
<h2>Registered Peeps</h2>
<a href="hello.do">Add another!</a>
<table>
	<tr>
		<th>Name</th><th>Email</th><th>Age</th>
		<c:forEach var="person" items="${people}">
			<tr>
				<td><c:out value="${person.name}"></c:out></td>
				<td><c:out value="${person.email}"></c:out></td>
				<td><c:out value="${person.age}"></c:out></td>
			</tr>
		</c:forEach>
	</tr>
	
</table>
</body>
</html>