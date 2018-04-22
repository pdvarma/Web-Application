 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Servlet output</title>
</head>
<body>
<jsp:useBean id="pinfo" class="com.as.app.extend.PersonalInfo" scope="session"/>
<font>First Name: </font>
<jsp:getProperty  name="pinfo" property="firstName"/><br>
<font>Last Name: </font>
<jsp:getProperty  name="pinfo" property="lastName"/><br>
<font>Middle Name: </font>
<jsp:getProperty  name="pinfo" property="middleName"/><br>
<font>Gender: </font>
<jsp:getProperty  name="pinfo" property="gender"/><br>

<jsp:useBean id="cinfo" class="com.as.app.extend.ContactInfo" scope="session"/>
<font>Address: </font>
<jsp:getProperty  name="cinfo" property="address"/><br>
<font>City: </font>
<jsp:getProperty  name="cinfo" property="city"/><br>
<font>State: </font>
<jsp:getProperty  name="cinfo" property="state"/><br>
<font>Country: </font>
<jsp:getProperty  name="cinfo" property="country"/><br>
<font>Phone: </font>
<jsp:getProperty  name="cinfo" property="phone"/><br>

<jsp:useBean id="binfo" class="com.as.app.extend.BankInfo" scope="session"/>
<font>Bank: </font>
<jsp:getProperty  name="binfo" property="bank"/><br>
<font>Account: </font>
<jsp:getProperty  name="binfo" property="account"/><br>
<font>SSN: </font>
<jsp:getProperty  name="binfo" property="ssn"/>


</body>
</html>