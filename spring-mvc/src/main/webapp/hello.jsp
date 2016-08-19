<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
	color: red;
}
</style>
</head>
<body>

<c:choose>
	<c:when test="${not empty user}">
		<h2>Hello, <c:out value="${user}"></c:out></h2>
	</c:when>
	<c:otherwise>
		<h2>Stranger danger! RUN!</h2>
	</c:otherwise>
</c:choose>

<br />


<form:form action="register.do" method="post" commandName="pickle"><!-- path is like the name, but uses the bean property as a reference -->
	Name: <form:input path="name" /> <form:errors path="name" cssClass="error"/><br />
	Age: <form:input path="age" /> <form:errors path="age" cssClass="error"/><br />
	Email: <form:input path="email" /> <form:errors path="email" cssClass="error"/><br />
	<input type="submit" value="Register" />
</form:form>
</body>
</html>