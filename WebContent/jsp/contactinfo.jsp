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
	<form method="post" action="/JavaBeansDemo/contactInfo">
		<table align="center">
			<tr>
				<td>Address:</td>
				<td><input type="text" id="address" name="address" value=" "></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" id="city" name="city" value=" "></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" id="state" name="state" value=" "></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" id="country" name="country" value=" "></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" id="phone" name="phone" value=" "></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>

</html>