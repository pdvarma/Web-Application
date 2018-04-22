
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Servlet output</title>
</head>
<body>
	<font>First Name: </font>
	<c:out value="${pinfo.firstName}"></c:out>
	<br>
	<font>Last Name: </font>
	<c:out value="${pinfo.lastName}"></c:out>
	<br>
	<font>Middle Name: </font>
	<c:out value="${pinfo.middleName}"></c:out>
	<br>
	<font>Gender: </font>
	<c:out value="${pinfo.gender}"></c:out>
	<br>
	<font>Address: </font>
	<c:out value="${cinfo.address}"></c:out>
	<br>
	<font>City: </font>
	<c:out value="${cinfo.city}"></c:out>
	<br>
	<font>State: </font>
	<c:out value="${cinfo.state}"></c:out>
	<br>
	<font>Country: </font>
	<c:out value="${cinfo.country}"></c:out>
	<br>
	<font>Phone: </font>
	<c:out value="${cinfo.phone}"></c:out>
	<br>

	<font>Bank: </font>
	<c:out value="${binfo.bank}"></c:out>
	<br>
	<font>Account: </font>
	<c:out value="${binfo.account}"></c:out>
	<br>
	<font>SSN: </font>
	<c:out value="${binfo.ssn}"></c:out>
	<br>


</body>
</html>