<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String pageErrors ="";
	Object obj = request.getAttribute("errors");
	if(obj != null){
		pageErrors = (String) obj;
	}
	if(pageErrors != null && pageErrors.trim().length() != 0){
		
	%>
	<font color="red"><%= pageErrors %></font>
	<% } %>
	<form method="post" action="/JavaBeansDemo/bankinfo">
		<table align="center">
			<tr>
				<td>Bank name:</td>
				<td><input type="text" id="bank" name="bank" value=""></td>
			</tr>
			<tr>
				<td>Account no:</td>
				<td><input type="text" id="account" name="account" value=""></td>
			</tr>
			<tr>
				<td>SSN:</td>
				<td><input type="text" id="ssn" name="ssn" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>