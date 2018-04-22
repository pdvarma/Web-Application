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
	<form method="post" action="/JavaBeansDemo/personalinfo">
		<table align="center">
			<tr>
				<td><label>First name:</label></td>
				<td><input type="text" id="firstname" name="firstname" value=""></td>
			</tr>
			<tr>
				<td><label>Last name:</label></td>
				<td><input type="text" id="lastname" name="lastname" value=""></td>
			</tr>
			<tr>
				<td><label>Middle name:</label></td>
				<td><input type="text" id="middlename" name="middlename"
					value="">
				<td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" id="gender" value="male"
					checked> Male <input type="radio" name="gender" id="gender"
					value="female"> Female</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>